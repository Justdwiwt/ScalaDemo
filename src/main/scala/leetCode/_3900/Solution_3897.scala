package leetCode._3900

object Solution_3897 {
  private val MOD = 1000000007L
  private val MX = 10001

  private val pow2 = (1 until MX).scanLeft(1L)((p, _) => p * 2 % MOD).toArray

  def maxValue(nums1: Array[Int], nums0: Array[Int]): Int = nums1
    .indices
    .sortBy(i => (nums0(i) != 0, -nums1(i), nums0(i)))
    .foldLeft(0L)((ans, i) => (((ans + 1) * pow2(nums1(i)) % MOD - 1 + MOD) % MOD * pow2(nums0(i))) % MOD)
    .toInt
}
