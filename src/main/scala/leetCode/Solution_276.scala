package leetCode

object Solution_276 {
  def numWays(n: Int, k: Int): Int = {
    if (n == 0 || k == 0) return 0
    if (n == 1) return k
    val dp = Array.fill(n)(0)
    dp(0) = k
    dp(1) = k * k
    (2 until n).foreach(i => dp(i) = dp(i - 2) * (k - 1) + dp(i - 1) * (k - 1))
    dp(n - 1)
  }
}
