package leetCode

object Solution_562 {
  def longestLine(M: Array[Array[Int]]): Int = {
    if (M.isEmpty || M.head.isEmpty) return 0
    val row = M.length
    val col = M.head.length
    var res = 0
    val dp = Array.ofDim[Int](row + 2, col + 2, 4)
    (1 to row).foreach(i => (1 to col).foreach(j => if (M(i - 1)(j - 1) == 1) {
      dp(i)(j)(0) = dp(i - 1)(j)(0) + 1
      dp(i)(j)(1) = dp(i)(j - 1)(1) + 1
      dp(i)(j)(2) = dp(i - 1)(j - 1)(2) + 1
      res = res.max(dp(i)(j)(0)).max(dp(i)(j)(1).max(dp(i)(j)(2)))
    }))
    (1 to row).foreach(i => (1 to col).reverse.foreach(j => if (M(i - 1)(j - 1) == 1) {
      dp(i)(j)(3) = dp(i - 1)(j + 1)(3) + 1
      res = res.max(dp(i)(j)(3))
    }))
    res
  }
}
