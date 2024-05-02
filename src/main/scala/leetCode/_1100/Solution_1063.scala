package leetCode._1100

object Solution_1063 {
  def validSubarrays(nums: Array[Int]): Int = nums
    .indices
    .map(i => (i + 1 until nums.length).takeWhile(nums(i) <= nums(_)).size + 1)
    .sum
}
