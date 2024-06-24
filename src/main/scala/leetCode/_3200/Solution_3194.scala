package leetCode._3200

object Solution_3194 {
  def minimumAverage(nums: Array[Int]): Double = {
    val sorted = nums.sorted
    (0 until nums.length / 2).map(i => sorted(i) + sorted(sorted.length - 1 - i)).min / 2.0
  }
}
