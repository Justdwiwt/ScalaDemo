package leetCode

object Solution_1822 {
  def arraySign(nums: Array[Int]): Int =
    nums.map(i => math.signum(i)).product
}
