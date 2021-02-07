package leetCode

object Solution_1413 {
  def minStartValue(nums: Array[Int]): Int =
    (1 - nums.scanLeft(0)(_ + _).drop(1).min).max(1)
}
