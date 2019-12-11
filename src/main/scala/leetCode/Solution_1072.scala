package leetCode

object Solution_1072 {
  def maxEqualRowsAfterFlips(matrix: Array[Array[Int]]): Int = {
    matrix.map(_.toList).map({ case h :: t => t.map(_ ^ h) }).groupBy(x => x).values.map(_.length).max
  }
}
