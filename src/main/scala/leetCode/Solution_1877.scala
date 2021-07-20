package leetCode

object Solution_1877 {
  def minPairSum(nums: Array[Int]): Int = {
    val sorted = nums.sorted
    (0 until nums.length / 2).map(i => sorted(i) + sorted(nums.length - 1 - i)).max
  }
}
