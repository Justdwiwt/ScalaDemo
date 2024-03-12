package leetCode._2800

object Solution_2770 {
  def maximumJumps(nums: Array[Int], target: Int): Int = {
    val dp = Array.fill(nums.length)(0)
    dp(0) = 1
    nums.indices.drop(1).foreach(i => (0 until i).foreach(j => {
      if ((nums(i) - nums(j)) <= target && (nums(i) - nums(j)) >= -target && dp(j) != 0)
        dp(i) = dp(i).max(dp(j) + 1)
    }))
    dp(nums.length - 1) - 1
  }
}
