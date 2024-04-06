package leetCode._400

object Solution_322 {
  def coinChange(coins: Array[Int], amount: Int): Int = {
    val dp = Array.fill(amount + 1)(Int.MaxValue)
    dp(0) = 0
    dp.indices.foreach(idx => coins
      .withFilter(coin => coin <= idx && dp(idx - coin) != Int.MaxValue)
      .foreach(coin => {
        val compare = dp(idx - coin) + 1
        dp(idx) = dp(idx).min(compare)
      })
    )
    if (dp(amount) != Int.MaxValue) dp(amount) else -1
  }
}
