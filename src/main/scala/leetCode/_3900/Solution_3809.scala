package leetCode._3900

object Solution_3809 {
  def bestTower(towers: Array[Array[Int]], center: Array[Int], radius: Int): Array[Int] = {
    val filtered = towers.filter(MHD(_, center) <= radius)

    if (filtered.isEmpty) return Array(-1, -1)

    val sorted = filtered
      .map(x => (x.head, x(1), x(2)))
      .sortBy(t => (-t._3, t._1, t._2))

    Array(sorted.head._1, sorted.head._2)
  }

  def MHD(tower: Array[Int], center: Array[Int]): Int =
    (tower.head - center.head).abs + (tower(1) - center(1)).abs
}
