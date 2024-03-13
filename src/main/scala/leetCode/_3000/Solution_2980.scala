package leetCode._3000

object Solution_2980 {
  def hasTrailingZeros(nums: Array[Int]): Boolean =
    nums.count(_ % 2 == 0) > 1
}
