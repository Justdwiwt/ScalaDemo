package leetCode._4000

object Solution_3974 {
  def maxSum(nums: Array[Int], k: Int, mul: Int): Long = nums
    .sorted(Ordering.Int.reverse)
    .take(k)
    .zipWithIndex
    .map { case (x, i) => val m = mul - i; if (m > 1) x.toLong * m else x.toLong }
    .sum
}
