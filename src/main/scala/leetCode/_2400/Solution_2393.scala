package leetCode._2400

object Solution_2393 {
  def countSubarrays(nums: Array[Int]): Long = {
    var res = 0L
    val dp = Array.fill(nums.length)(0L)
    nums.indices.foreach(i => {
      if (i > 0 && nums(i - 1) < nums(i)) dp(i) = dp(i - 1) + 1
      else dp(i) = 1
      res += dp(i)
    })
    res
  }
}
