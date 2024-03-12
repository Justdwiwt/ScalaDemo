package leetCode._2800

object Solution_2733 {
  def findNonMinOrMax(nums: Array[Int]): Int = nums
    .find(n => n != nums.min && n != nums.max)
    .getOrElse(-1)
}
