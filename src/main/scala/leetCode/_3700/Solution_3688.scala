package leetCode._3700

object Solution_3688 {
  def evenNumberBitwiseORs(nums: Array[Int]): Int =
    nums.filter(_ % 2 == 0).fold(0)(_ | _)
}
