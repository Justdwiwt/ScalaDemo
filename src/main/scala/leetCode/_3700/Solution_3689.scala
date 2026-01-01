package leetCode._3700

object Solution_3689 {
  def maxTotalValue(nums: Array[Int], k: Int): Long =
    k.toLong * (nums.max - nums.min)
}
