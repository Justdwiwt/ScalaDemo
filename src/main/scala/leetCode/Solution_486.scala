package leetCode

object Solution_486 {
  def PredictTheWinner(nums: Array[Int]): Boolean = {
    val sum = nums.sum
    val dp = Array.ofDim[Int](nums.length, nums.length)
    nums.indices.foreach(i => dp(i)(i) = nums(i))
    (1 until nums.length).foreach(i => dp(i - 1)(i) = dp(i - 1)(i - 1).max(dp(i)(i)))
    (2 until nums.length).foreach(i => (0 until nums.length - i).foreach(row => {
      dp(row)(row + i) = (nums(row) + dp(row + 1)(i + row - 1).min(dp(row + 2)(i + row))).max(nums(i + row) + dp(row)(i + row - 2).min(dp(row + 1)(i + row - 1)))
    }))
    dp(0)(nums.length - 1) >= (sum - dp(0)(nums.length - 1))
  }
}
