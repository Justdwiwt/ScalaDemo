package leetCode._3700

object Solution_3686 {
  def countStableSubsequences(nums: Array[Int]): Int = {
    val M = 1000000007L

    val (a0, b0, a1, b1) = nums.foldLeft((0L, 0L, 0L, 0L)) { case ((f00, f01, f10, f11), x0) =>
      val x = x0 & 1
      if (x == 0) {
        val n01 = (f01 + f00) % M
        val n00 = (f00 + f10 + f11 + 1) % M
        (n00, n01, f10, f11)
      } else {
        val n11 = (f11 + f10) % M
        val n10 = (f10 + f00 + f01 + 1) % M
        (f00, f01, n10, n11)
      }
    }

    ((a0 + b0 + a1 + b1) % M).toInt
  }
}
