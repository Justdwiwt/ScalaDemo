package leetCode._900

object Solution_846 {
  def isNStraightHand(hand: Array[Int], groupSize: Int): Boolean = {
    @scala.annotation.tailrec
    def f(map: Map[Int, Int]): Boolean = {
      lazy val mn = map.minBy(_._1)._1
      lazy val ind = mn until mn + groupSize
      lazy val newMap = ind
        .foldLeft(map) { case (_map, i) => _map.updated(i, _map(i) - 1) }
        .filter { case (_, count) => count > 0 }
      map.isEmpty || (ind.forall(map.contains) && f(newMap))
    }

    f(hand.groupBy(identity).mapValues(_.length))
  }
}
