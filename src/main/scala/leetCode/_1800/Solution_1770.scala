package leetCode._1800

object Solution_1770 {
  def maximumScore(nums: Array[Int], multipliers: Array[Int]): Int = {
    val n = nums.length
    val m = multipliers.length
    val d = Array.ofDim[Int](m + 1, m + 1)
    (m - 1 to 0 by -1).foreach(i => (i to 0 by -1)
      .foreach(j => d(i)(j) = (nums(j) * multipliers(i) + d(i + 1)(j + 1)).max(nums(n - 1 + j - i) * multipliers(i) + d(i + 1)(j))))
    d.head.head
  }
}
