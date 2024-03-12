package leetCode._100

object Solution_53 {
  def maxSubArray(nums: Array[Int]): Int =
    nums.tail.scan(nums.head)((x, y) => y.max(x + y)).max
}
