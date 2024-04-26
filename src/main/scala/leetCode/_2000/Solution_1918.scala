package leetCode._2000

object Solution_1918 {
  def kthSmallestSubarraySum(nums: Array[Int], k: Int): Int = {
    var l = 0
    var r = nums.sum
    while (l < r) {
      val m = l + (r - l) / 2
      if (f(nums, m) >= k) r = m
      else l = m + 1
    }
    l
  }

  private def f(nums: Array[Int], k: Int): Int = {
    var slow = 0
    var fast = 0
    var res = 0
    val n = nums.length
    var sum = 0L
    while (fast < n) {
      sum += nums(fast)
      while (slow <= fast && sum > k) {
        sum -= nums(slow)
        slow += 1
      }
      res += (fast - slow + 1)
      fast += 1
    }
    res
  }
}
