package leetCode

object Solution_300 {
  def lengthOfLIS(nums: Array[Int]): Int = {
    val dp = Array.fill(nums.length)(1)
    var res = 1
    nums.indices.reverse.foreach(i => (i until nums.length).foreach(j => {
      if (nums(i) < nums(j)) {
        dp(i) = dp(i).max(1 + dp(j))
        res = res.max(dp(i))
      }
    }))
    res
  }
}
