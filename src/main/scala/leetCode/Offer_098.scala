package leetCode

object Offer_098 {
  def uniquePaths(m: Int, n: Int): Int = {
    val dp = Array.fill(n)(1)
    (1 until m).foreach(_ => (1 until n).foreach(j => dp(j) += dp(j - 1)))
    dp(n - 1)
  }
}
