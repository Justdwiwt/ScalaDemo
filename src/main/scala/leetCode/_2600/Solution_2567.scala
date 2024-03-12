package leetCode._2600

object Solution_2567 {
  def minimizeSum(nums: Array[Int]): Int = {
    val sorted = nums.sorted
    (sorted.last - sorted(2)).min(sorted(sorted.length - 3) - sorted.head).min(sorted(sorted.length - 2) - sorted(1))
  }
}
