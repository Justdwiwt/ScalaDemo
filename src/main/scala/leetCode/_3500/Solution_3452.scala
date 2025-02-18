package leetCode._3500

object Solution_3452 {
  def sumOfGoodNumbers(nums: Array[Int], k: Int): Int = nums
    .indices
    .filter(i => (i < k || nums(i) > nums(i - k)) && (i + k >= nums.length || nums(i) > nums(i + k)))
    .map(nums)
    .sum
}
