package leetCode

object Solution_1262 {
  def maxSumDivThree(nums: Array[Int]): Int = {
    var dp = Array(0, Int.MinValue, Int.MinValue)
    nums.foreach(i => {
      val diff = Array(0, 0, 0)
      (0 until 3).foreach(j => diff((j + i) % 3) = dp((j + i) % 3).max(dp(j) + i))
      dp = diff
    })
    dp(0)
  }
}
