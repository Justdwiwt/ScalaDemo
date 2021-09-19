package leetCode

object Solution_115 {
  def numDistinct(s: String, t: String): Int = {
    val dp = Array.ofDim[Int](t.length + 1)
    dp(0) = 1
    s.foreach(c => (1 to t.length).reverse.withFilter(i => t(i - 1) == c).foreach(i => dp(i) += dp(i - 1)))
    dp.last
  }
}
