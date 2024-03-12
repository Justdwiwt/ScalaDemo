package leetCode._300

object Solution_218 {
  def criticalPoints(buildings: Array[Array[Int]]): List[(Int, Int)] =
    buildings.map(b => List(b.head -> b(2), b(1) -> b(2))).toList.flatten.sortBy(_._1)

  def filterPoints(points: List[Array[Int]]): List[Array[Int]] = points match {
    case Nil => Nil
    case h :: n :: t if h(1) == n(1) => filterPoints(h :: t)
    case h :: t => h :: filterPoints(t)
  }

  def getSkyline(buildings: Array[Array[Int]]): List[List[Int]] =
    filterPoints(criticalPoints(buildings).map(cp => {
      val overlapping = buildings.filter(b => b.head <= cp._1 && b(1) > cp._1)
      val height = if (overlapping.isEmpty) 0 else overlapping.map(_ (2)).max
      Array(cp._1, height)
    })).map(_.toList)

  def _getSkyline(buildings: Array[Array[Int]]): List[Array[Int]] = buildings
    .map(b => List(b.head -> b(2), b(1) -> b(2)))
    .toList.flatten.sortBy(_._1)
    .map(cp => Array(cp._1, buildings.filter(b => b.head <= cp._1 && b(1) > cp._1).map(_ (2)).reduceOption(_.max(_)).getOrElse(0)))
    ./:(List.empty[Array[Int]])((l, n) => l.lastOption.map(m => if (m(1) == n(1)) l else l :+ n).map(_.toList).getOrElse(List(n)))
}
