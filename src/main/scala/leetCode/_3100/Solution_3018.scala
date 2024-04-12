package leetCode._3100

object Solution_3018 {
  def maximumProcessableQueries(nums: Array[Int], queries: Array[Int]): Int = {
    val n = nums.length
    val dp = Array.fill(n + 1, n + 1)(0)
    ((n - 1) to 0 by -1).foreach(delta => (delta to n).foreach(j => {
      val tmp = j - delta
      if (tmp > 0) {
        if (dp(tmp - 1)(j) < queries.length && nums(tmp - 1) >= queries(dp(tmp - 1)(j)))
          dp(tmp)(j) = dp(tmp - 1)(j) + 1
        else dp(tmp)(j) = dp(tmp - 1)(j)
      }
      if (j < nums.length) {
        if (dp(tmp)(j + 1) < queries.length && nums(j) >= queries(dp(tmp)(j + 1)))
          dp(tmp)(j) = dp(tmp)(j).max(dp(tmp)(j + 1) + 1)
        else dp(tmp)(j) = dp(tmp)(j).max(dp(tmp)(j + 1))
      }
    }))
    dp.map(_.max).max
  }
}
