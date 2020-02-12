package leetCode

object Offer_10_2 {
  def numWays(n: Int): Int = n match {
    case 0 => 1
    case _ =>
      val dp = Array.fill(n + 1)(0)
      dp(0) = 1
      dp(1) = 1
      (2 until (n + 1)).foreach(i => {
        dp(i) = dp(i - 1) + dp(i - 2)
        if (dp(i) >= 1000000007) dp(i) -= 1000000007
      })
      dp(n)
  }
}
