package leetCode._1500

object Solution_1413 {
  def minStartValue(nums: Array[Int]): Int =
    1 - nums.scanLeft(0)(_ + _).min
}
