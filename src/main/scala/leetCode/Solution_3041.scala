package leetCode

object Solution_3041 {
  def maxSelectedElements(nums: Array[Int]): Int = {
    val sorted = nums.sorted
    val mx = sorted.last
    val dp = Array.fill(mx + 2)(0)
    dp(sorted.head) = 1
    dp(sorted.head + 1) = 1
    var res = 1
    nums.indices.drop(1).foreach(i => {
      dp(sorted(i) + 1) = dp(sorted(i)) + 1
      dp(sorted(i)) = dp(sorted(i) - 1) + 1
      res = res.max(dp(sorted(i)).max(dp(sorted(i) + 1)))
    })
    res
  }
}
