package leetCode

object Solution_2016 {
  def maximumDifference(nums: Array[Int]): Int = nums./:(Int.MaxValue, -1) {
    case ((mn, mx), n) => if (n <= mn) (n, mx) else (mn, mx.max(n - mn))
  }._2
}
