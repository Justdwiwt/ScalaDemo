package leetCode._1900

object Solution_1822 {
  def arraySign(nums: Array[Int]): Int =
    nums.map(math.signum).product
}
