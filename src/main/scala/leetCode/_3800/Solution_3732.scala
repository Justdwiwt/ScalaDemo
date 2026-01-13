package leetCode._3800

object Solution_3732 {
  def maxProduct(nums: Array[Int]): Long = nums
    .map(math.abs(_).toLong)
    .sorted
    .takeRight(2) match {
    case Array(a, b) => 100000L * a * b
  }
}
