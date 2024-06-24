package leetCode._3200

object Solution_3190 {
  def minimumOperations(nums: Array[Int]): Int =
    nums.count(_ % 3 != 0)
}
