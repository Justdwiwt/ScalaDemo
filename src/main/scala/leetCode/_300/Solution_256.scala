package leetCode._300

object Solution_256 {
  def minCost(costs: Array[Array[Int]]): Int = {
    if (costs.isEmpty) return 0
    val dp = Array.ofDim[Int](costs.length + 1, 3)
    dp.indices.foreach(i => (0 until 3).foreach(j => {
      if (i == 0) dp(i)(j) = 0
      else dp(i)(j) = dp(i - 1)((j + 1) % 3).min(dp(i - 1)((j + 2) % 3)) + costs(i - 1)(j)
    }))
    dp(costs.length)(0).min(dp(costs.length)(1).min(dp(costs.length)(2)))
  }
}
