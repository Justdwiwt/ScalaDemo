package leetCode

object Solution_322 {
  def coinChange(coins: Array[Int], amount: Int): Int = {
    val dp = Array.fill(amount + 1)(amount + 1)
    dp(0) = 0
    (1 to amount).foreach(i => coins.indices.foreach(j => if (coins(j) <= i) dp(i) = dp(i).min(dp(i - coins(j)) + 1)))
    if (dp(amount) > amount) -1 else dp(amount)
  }
}
