package leetCode

object Solution_1072 {
  def maxEqualRowsAfterFlips(matrix: Array[Array[Int]]): Int = (matrix.filter(_.head == 1) ++ matrix.filter(_.head == 0)
    .map(_.map(x => (x - 1).abs)))
    .map(_.toList)
    .groupBy(identity)
    .mapValues(_.length)
    .values
    .max
}
