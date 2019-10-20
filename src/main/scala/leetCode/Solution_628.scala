package leetCode

object Solution_628 {
  def maximumProduct(nums: Array[Int]): Int = {
    util.Sorting.quickSort(nums)
    val a = nums(0) * nums(1) * nums(nums.length - 1)
    val b = nums(nums.length - 3) * nums(nums.length - 2) * nums(nums.length - 1)
    math.max(a, b)
  }
}
