package leetCode

object Offer_119 {
  def longestConsecutive(nums: Array[Int]): Int = {
    val sorted = nums.sorted.distinct
    val dp = Array.fill(sorted.length)(1)
    sorted.indices.drop(1).foreach(i => if (sorted(i) - sorted(i - 1) == 1) dp(i) = dp(i - 1) + 1)
    if (dp.isEmpty) 0 else dp.max
  }
}
