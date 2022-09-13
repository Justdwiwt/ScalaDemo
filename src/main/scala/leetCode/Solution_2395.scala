package leetCode

object Solution_2395 {
  def findSubarrays(nums: Array[Int]): Boolean = nums
    .indices
    .tail
    .map(k => nums(k) + nums(k - 1))
    .distinct
    .size < nums.length - 1
}
