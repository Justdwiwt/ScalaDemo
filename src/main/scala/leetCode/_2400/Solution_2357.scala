package leetCode._2400

object Solution_2357 {
  def minimumOperations(nums: Array[Int]): Int = nums
    .distinct
    .count(_ > 0)
}
