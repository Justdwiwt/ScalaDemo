package leetCode

object Solution_3028 {
  def returnToBoundaryCount(nums: Array[Int]): Int = nums
    .scanLeft(0)(_ + _)
    .tail
    .count(_ == 0)
}
