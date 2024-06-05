package leetCode._1600

object Solution_1537 {
  def maxSum(nums1: Array[Int], nums2: Array[Int]): Int = {
    val M = 1000000007

    @scala.annotation.tailrec
    def f(i: Int, j: Int, sum1: Long, sum2: Long): Long = (i, j) match {
      case (m, n) if m == nums1.length && n == nums2.length => sum1.max(sum2)
      case (m, _) if m == nums1.length => f(i, j + 1, sum1, sum2 + nums2(j))
      case (_, n) if n == nums2.length => f(i + 1, j, sum1 + nums1(i), sum2)
      case (_, _) if nums1(i) < nums2(j) => f(i + 1, j, sum1 + nums1(i), sum2)
      case (_, _) if nums1(i) > nums2(j) => f(i, j + 1, sum1, sum2 + nums2(j))
      case (_, _) if nums1(i) == nums2(j) =>
        val newSum = sum1.max(sum2) + nums1(i)
        f(i + 1, j + 1, newSum, newSum)
    }

    (f(0, 0, 0L, 0L) % M).toInt
  }
}
