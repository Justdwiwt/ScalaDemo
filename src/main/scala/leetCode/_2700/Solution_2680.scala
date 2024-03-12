package leetCode._2700

object Solution_2680 {
  def maximumOr(nums: Array[Int], k: Int): Long = {
    val prefixOr = nums.scanLeft(0L)(_ | _)
    val suffixOr = nums.scanRight(0L)(_ | _)
    nums.indices.map(i => prefixOr(i) | (nums(i).toLong << k) | suffixOr(i + 1)).max
  }
}
