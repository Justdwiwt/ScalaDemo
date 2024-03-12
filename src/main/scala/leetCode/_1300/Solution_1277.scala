package leetCode._1300

object Solution_1277 {
  def countSquares(matrix: Array[Array[Int]]): Int = {
    val dp = Array.fill(matrix.length, matrix(0).length)(0)
    var res = 0
    matrix.indices.foreach(i => matrix(0).indices.foreach(j => {
      if (i == 0 || j == 0) dp(i)(j) = matrix(i)(j)
      else if (matrix(i)(j) == 0) dp(i)(j) = 0
      else dp(i)(j) = dp(i)(j - 1).min(dp(i - 1)(j)).min(dp(i - 1)(j - 1)) + 1
      res += dp(i)(j)
    }))
    res
  }
}
