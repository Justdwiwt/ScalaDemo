package leetCode._2600

object Solution_2527 {
  def xorBeauty(nums: Array[Int]): Int =
    nums.reduce(_ ^ _)
}
