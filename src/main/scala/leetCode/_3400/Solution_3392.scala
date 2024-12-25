package leetCode._3400

object Solution_3392 {
  def countSubarrays(nums: Array[Int]): Int =
    nums.zipWithIndex.count { case (_, i) => i >= 2 && (nums(i - 2) + nums(i)) * 2 == nums(i - 1) }
}
