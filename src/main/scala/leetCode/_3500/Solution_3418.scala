package leetCode._3500

object Solution_3418 {
  def maximumAmount(coins: Array[Array[Int]]): Int = {
    val n = coins.length
    val m = coins.head.length
    val INF: Long = 1e18.toLong
    val dp = Array.fill(n, m, 3)(-INF)
    dp(0)(0)(0) = coins(0)(0)
    dp(0)(0)(1) = 0
    coins.indices.foreach(i => coins.head.indices.foreach(j => {
      (0 until 3).foreach(k => {
        if (i > 0) dp(i)(j)(k) = dp(i)(j)(k).max(dp(i - 1)(j)(k) + coins(i)(j))
        if (j > 0) dp(i)(j)(k) = dp(i)(j)(k).max(dp(i)(j - 1)(k) + coins(i)(j))
      })
      (1 until 3).foreach(k => {
        if (i > 0) dp(i)(j)(k) = dp(i)(j)(k).max(dp(i - 1)(j)(k - 1))
        if (j > 0) dp(i)(j)(k) = dp(i)(j)(k).max(dp(i)(j - 1)(k - 1))
      })
    }))
    (0 until 3).map(dp(n - 1)(m - 1)(_)).max.toInt
  }
}
