package leetCode._3700

object Solution_3674 {
  def minOperations(nums: Array[Int]): Int =
    if (nums.forall(_ == nums(0))) 0 else 1
}
