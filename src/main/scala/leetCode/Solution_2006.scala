package leetCode

object Solution_2006 {
  def countKDifference(nums: Array[Int], k: Int): Int = nums
    .indices
    .combinations(2)
    .count({ case Seq(i, j) => (nums(j) - nums(i)).abs == k })
}
