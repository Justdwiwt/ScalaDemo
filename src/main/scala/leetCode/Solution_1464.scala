package leetCode

object Solution_1464 {
  def maxProduct(nums: Array[Int]): Int = {
    val t = nums.sorted.reverse
    (t(0) - 1) * (t(1) - 1)
  }
}
