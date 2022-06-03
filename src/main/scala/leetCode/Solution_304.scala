package leetCode

object Solution_304 {

  class NumMatrix(_matrix: Array[Array[Int]]) {

    private val prefixSums = _matrix.map(_.scanLeft(0)(_ + _))

    def sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int = (row1 to row2)./:(0) { case (sum, row) =>
      sum + (prefixSums(row)(col2 + 1) - prefixSums(row)(col1))
    }
  }

}
