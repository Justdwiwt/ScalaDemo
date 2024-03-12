package leetCode.offer

object Offer_14_1 {
  def cuttingRope(n: Int): Int = {
    val dp = Array.fill(n + 1)(0)
    dp(0) = 1
    (1 until n).foreach(i => (i to n).foreach(j => dp(j) = dp(j).max(dp(j - i) * i)))
    dp(n)
  }
}
