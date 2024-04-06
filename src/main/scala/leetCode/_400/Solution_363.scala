package leetCode._400

object Solution_363 {
  def maxSumSubmatrix(matrix: Array[Array[Int]], k: Int): Int = {
    val rows = matrix.length
    val cols = matrix.head.length
    val prefixSum = Array.ofDim[Int](rows + 1, cols + 1)
    matrix.indices.foreach(r => matrix.head.indices.foreach(c => prefixSum(r + 1)(c + 1) = prefixSum(r)(c + 1) + prefixSum(r + 1)(c) - prefixSum(r)(c) + matrix(r)(c)))
    var max = Int.MinValue
    matrix.indices.foreach(rowSize => matrix.head.indices.foreach(colSize => (0 until rows - rowSize).foreach(rStart => (0 until cols - colSize).foreach(cStart => {
      val sum = prefixSum(rStart + rowSize + 1)(cStart + colSize + 1) + prefixSum(rStart)(cStart) - prefixSum(rStart)(cStart + colSize + 1) - prefixSum(rStart + rowSize + 1)(cStart)
      if (sum == k) max = k
      else if (sum < k) max = max.max(sum)
    }))))
    max
  }
}
