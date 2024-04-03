package leetCode._700

object Solution_698 {
  def canPartitionKSubsets(nums: Array[Int], k: Int): Boolean =
    nums.sum % k == 0 && f(nums.toIndexedSeq, nums.sum / k)

  private def f(s: Seq[Int], t: Int): Boolean =
    s.isEmpty || 1.to(s.size).exists(s.combinations(_).exists(c => c.sum == t && f(s diff c, t)))
}
