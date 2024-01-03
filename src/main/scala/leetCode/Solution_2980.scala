package leetCode

object Solution_2980 {
  def hasTrailingZeros(nums: Array[Int]): Boolean =
    nums.map(n => (n + 1) % 2).sum > 1
}
