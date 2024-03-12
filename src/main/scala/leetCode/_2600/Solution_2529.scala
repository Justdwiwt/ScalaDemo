package leetCode._2600

object Solution_2529 {
  def maximumCount(nums: Array[Int]): Int = nums
    .count(_ > 0)
    .max(nums.count(_ < 0))
}
