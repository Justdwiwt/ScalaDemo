package leetCode._3900

object Solution_3810 {
  def minOperations(nums: Array[Int], target: Array[Int]): Int = nums
    .zip(target)
    .collect { case (v1, v2) if v1 != v2 => v1 }
    .distinct
    .length
}
