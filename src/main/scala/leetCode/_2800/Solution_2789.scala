package leetCode._2800

object Solution_2789 {
  def maxArrayValue(nums: Array[Int]): Long =
    nums.:\(0L) { case (n, x) => if (n > x) n else x + n }
}
