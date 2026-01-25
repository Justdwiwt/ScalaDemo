package leetCode._3800

object Solution_3774 {
  def absDifference(nums: Array[Int], k: Int): Int = nums
    .sorted
    .reverse
    .take(k)
    .sum - nums
    .sorted
    .take(k)
    .sum
}
