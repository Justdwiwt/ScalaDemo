package leetCode._4000

object Solution_3979 {
  def maxValidPairSum(nums: Array[Int], k: Int): Int = nums
    .indices
    .drop(k)
    .scanLeft(0)((mx, j) => mx.max(nums(j - k)))
    .tail
    .zip(nums.drop(k))
    .map { case (mx, x) => mx + x }
    .max
}
