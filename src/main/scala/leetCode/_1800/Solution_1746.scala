package leetCode._1800

object Solution_1746 {
  def maxSumAfterOperation(nums: Array[Int]): Int = {
    val INF = 0x3f3f3f3f
    val n = nums.length
    var res = 0
    val dp = Array.fill(n + 1, 2)(0)
    dp(0)(1) = -INF
    (1 to nums.length).foreach(i => {
      dp(i)(0) = nums(i - 1).max(dp(i - 1)(0) + nums(i - 1))
      dp(i)(1) = (nums(i - 1) * nums(i - 1) + 0.max(dp(i - 1)(0))).max(nums(i - 1) + 0.max(dp(i - 1)(1)))
      res = res.max(dp(i)(0).max(dp(i)(1)))
    })
    res
  }
}
