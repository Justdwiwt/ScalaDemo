package leetCode._3200

object Solution_3107 {
  def minOperationsToMakeMedianK(nums: Array[Int], k: Int): Long = {
    val sorted = nums.sorted
    val m = sorted.length / 2
    if (sorted(m) > k) (m to 0 by -1).filter(sorted(_) > k).map(sorted(_).toLong - k).sum
    else (m until sorted.length).filter(sorted(_) < k).map(k.toLong - sorted(_)).sum
  }
}
