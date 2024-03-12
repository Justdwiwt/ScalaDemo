package leetCode._1800

object Solution_1800 {
  def maxAscendingSum(nums: Array[Int]): Int = nums
    .indices
    .drop(1)
    ./:(nums.head, nums.head)((b, a) =>
      if (nums(a) > nums(a - 1)) (b._1 + nums(a), b._2.max(b._1 + nums(a)))
      else (nums(a), b._2.max(nums(a))))
    ._2
}
