package leetCode

object Solution_1770 {
  def maximumScore(nums: Array[Int], multipliers: Array[Int]): Int = {
    val n = nums.length
    val m = multipliers.length
    val dp = Array.fill(m + 1)(Array.fill(m + 1)(Int.MinValue))
    (0 to m).foreach(i => dp(i)(m - i) = 0)
    (m - 1 to 0).reverse.foreach(k => (0 to k).foreach(l => {
      val r = k - l
      dp(l)(r) = (dp(l + 1)(r) + nums(l) * multipliers(k)).max(dp(l)(r + 1) + nums(n - r - 1) * multipliers(k))
    }))
    dp.head.head
  }
}
