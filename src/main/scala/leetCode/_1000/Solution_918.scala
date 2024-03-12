package leetCode._1000

object Solution_918 {
  def maxSubarraySumCircular(A: Array[Int]): Int = {
    def f(nums: Array[Int]): Int = nums.tail.scanLeft(nums.head)((r, c) => c.max(r + c)).max

    if (A.forall(_ < 0)) A.max else f(A).max(A.sum + f(A.map(_ * -1)))
  }
}
