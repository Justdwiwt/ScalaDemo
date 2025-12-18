package leetCode._3700

object Solution_3640 {
  def maxSumTrionic(nums: Array[Int]): Long = {
    val neg = Long.MinValue / 4

    nums.sliding(2).foldLeft((neg, neg, neg, neg)) {
      case ((ans, f1, f2, f3), Array(x, y)) =>
        val Y = y.toLong
        val a1 = if (x < y) f1.max(x.toLong) + Y else neg
        val a2 = if (x > y) f2.max(f1) + Y else neg
        val a3 = if (x < y) f3.max(f2) + Y else neg
        (ans.max(a3), a1, a2, a3)
    }._1
  }
}
