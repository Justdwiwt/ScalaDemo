package leetCode

object Solution_2352 {
  def equalPairs(grid: Array[Array[Int]]): Int = grid
    .transpose
    .map(col => grid
      .map(_.toSeq.hashCode())
      .groupBy(identity)
      .mapValues(_.length)
      .getOrElse(col.toSeq.hashCode(), 0))
    .sum
}
