package leetCode._1800

object Solution_1775 {
  def minOperations(nums1: Array[Int], nums2: Array[Int]): Int = {
    if (nums1.length > nums2.length * 6 || nums2.length > nums1.length * 6) return -1
    val sm1 = nums1.sum
    val sm2 = nums2.sum
    if (sm1 > sm2) return minOperations(nums2, nums1)
    val n1 = nums1.sortWith(_ < _)
    val n2 = nums2.sortWith(_ < _)

    @scala.annotation.tailrec
    def f(op: Int, sm1: Int, sm2: Int, nums1: Array[Int], nums2: Array[Int], i: Int, j: Int): Int = {
      if (sm2 <= sm1) return op
      if (j < 0 || i < nums1.length && 6 - nums1(i) > nums2(j) - 1)
        f(op + 1, sm1 + 6 - nums1(i), sm2, nums1, nums2, i + 1, j)
      else
        f(op + 1, sm1, sm2 - nums2(j) + 1, nums1, nums2, i, j - 1)
    }

    f(0, sm1, sm2, n1, n2, 0, nums2.length - 1)
  }
}
