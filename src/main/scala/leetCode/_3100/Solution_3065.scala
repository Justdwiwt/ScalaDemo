package leetCode._3100

object Solution_3065 {
  def minOperations(nums: Array[Int], k: Int): Int =
    nums.count(_ < k)
}
