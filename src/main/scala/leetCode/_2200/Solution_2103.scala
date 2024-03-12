package leetCode._2200

object Solution_2103 {
  def countPoints(rings: String): Int = rings
    .sliding(2, 2)
    .map(n => (n.head, n.last))
    .toList
    .groupBy(_._2)
    .mapValues(_.toSet)
    .count(_._2.size == 3)
}
