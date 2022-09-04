package leetCode

object Solution_2374 {
  def edgeScore(edges: Array[Int]): Int = edges
    .zip(Stream.from(0))
    .groupBy(_._1)
    .map(n => (n._1, n._2.map(_._2.toLong).sum))
    .maxBy(n => (n._2, -n._1))
    ._1
}
