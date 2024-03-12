package leetCode._2400

object Solution_2366 {
  def minimumReplacement(nums: Array[Int]): Long = nums
    .:\(Int.MaxValue, 0L) { case (n, (right, cnt)) =>
      if (n <= right) (n, cnt)
      else {
        val div = (n - 1) / right + 1
        (n / div, cnt + div - 1)
      }
    }
    ._2
}
