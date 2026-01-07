package leetCode._3800

object Solution_3712 {
  def sumDivisibleByK(nums: Array[Int], k: Int): Int = nums
    .groupBy(identity)
    .filter(_._2.length % k == 0)
    .map(p => p._1 * p._2.length)
    .sum
}
