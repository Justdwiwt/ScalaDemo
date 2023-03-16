package leetCode

object Solution_2587 {
  def maxScore(nums: Array[Int]): Int = nums
    .sortBy(-_)
    .scanLeft(0L)(_ + _)
    .tail
    .takeWhile(_ > 0)
    .length
}
