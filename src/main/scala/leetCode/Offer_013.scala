package leetCode

object Offer_013 {
  class NumMatrix(matrix: Array[Array[Int]]) {
    private val (m, n) = (matrix.length, matrix.head.length)

    private val prefixSums = Array.ofDim[Int](m + 1, n + 1)

    matrix.indices.foreach(i => matrix(i).indices.foreach(j =>
      prefixSums(i + 1)(j + 1) = matrix(i)(j) + prefixSums(i)(j + 1) + prefixSums(i + 1)(j) - prefixSums(i)(j)))

    def sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int =
      prefixSums(row2 + 1)(col2 + 1) - prefixSums(row1)(col2 + 1) - prefixSums(row2 + 1)(col1) + prefixSums(row1)(col1)

  }
}
