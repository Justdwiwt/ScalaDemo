package leetCode

object Solution_1866 {
  def rearrangeSticks(n: Int, k: Int): Int = {
    val M = (1e9 + 7).toInt
    val dp = Array.fill(n + 1, k + 1)(0L)
    dp(0)(0) = 1L
    (1 to n).foreach(i => (1 to (i min k)).foreach(j => dp(i)(j) = (dp(i - 1)(j - 1) + (i - 1) * dp(i - 1)(j)) % M))
    dp.last.last.toInt
  }
}
