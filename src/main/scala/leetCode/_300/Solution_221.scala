package leetCode._300

object Solution_221 {
  def maximalSquare(matrix: Array[Array[Char]]): Int = {
    if (matrix.length < 1) return 0
    var mx = 0
    val dp = Array.ofDim[Int](matrix.length + 1, matrix(0).length + 1)
    (1 to matrix.length).foreach(i => (1 to matrix(0).length).foreach(j => {
      if (matrix(i - 1)(j - 1) == '1') {
        dp(i)(j) = 1 + dp(i - 1)(j - 1).min(dp(i - 1)(j).min(dp(i)(j - 1)))
        mx = mx.max(dp(i)(j))
      }
    }))
    mx * mx
  }
}
