package leetCode._1500

object Solution_1493 {
  @scala.annotation.tailrec
  def longestSubarray(nums: Array[Int], first: Int = 0, end: Int = 0, zeros: Int = 0): Int =
    if (end == nums.length) end - first - 1
    else if (zeros + (1 - nums(end)) <= 1) longestSubarray(nums, first, end + 1, zeros + (1 - nums(end)))
    else longestSubarray(nums, first + 1, end + 1, zeros + nums(first) - nums(end))
}
