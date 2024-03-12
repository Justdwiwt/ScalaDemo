package leetCode._600

object Solution_540 {
  def singleNonDuplicate(nums: Array[Int]): Int =
    nums.reduce(_ ^ _)
}
