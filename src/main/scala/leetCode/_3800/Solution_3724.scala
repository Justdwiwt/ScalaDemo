package leetCode._3800

object Solution_3724 {
  def minOperations(nums1: Array[Int], nums2: Array[Int]): Long = {
    val t = nums2.last
    val (a, m) = nums1.zip(nums2).foldLeft((1L, Long.MaxValue)) {
      case ((ans, mn), (p, q)) =>
        val x = math.min(p, q)
        val y = math.max(p, q)
        val d =
          if (t < x) x - t
          else if (t > y) t - y
          else 0
        (ans + y - x, math.min(mn, d.toLong))
    }
    a + m
  }
}
