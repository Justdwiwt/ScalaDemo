package leetCode

object Solution_2656 {
  def maximizeSum(nums: Array[Int], k: Int): Int =
    (2 * nums.max + (k - 1)) * k / 2
}
