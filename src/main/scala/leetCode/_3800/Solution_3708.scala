package leetCode._3800

object Solution_3708 {
  def longestSubarray(nums: Array[Int]): Int = {
    val (count, max, _, _) = nums.drop(2).foldLeft((2, 2, nums.tail.head, nums.head)) {
      case ((count, max, prev1, prev2), value) =>
        if (value == prev1 + prev2) (count + 1, max, value, prev1)
        else (2, max.max(count), value, prev1)
    }
    max.max(count)
  }
}
