package leetCode._2000

object Solution_1913 {
  def maxProductDifference(nums: Array[Int]): Int = {
    val sorted = nums.sorted
    sorted(nums.length - 1) * sorted(nums.length - 2) - sorted.head * sorted(1)
  }
}
