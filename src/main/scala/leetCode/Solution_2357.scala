package leetCode

object Solution_2357 {
  def minimumOperations(nums: Array[Int]): Int = nums
    .filter(_ > 0)
    .distinct
    .length
}
