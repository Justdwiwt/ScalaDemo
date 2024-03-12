package leetCode._3000

object Solution_2934 {
  def minOperations(nums1: Array[Int], nums2: Array[Int]): Int = {
    val n = nums1.length
    val res = f(nums1(n - 1), nums2(n - 1), nums1, nums2).min(1 + f(nums2(n - 1), nums1(n - 1), nums1, nums2))
    if (res > n) -1 else res
  }

  private def f(last1: Int, last2: Int, nums1: Array[Int], nums2: Array[Int]): Int = {
    var res = 0
    nums1.indices.dropRight(1).foreach(i => {
      val x = nums1(i)
      val y = nums2(i)
      if (x > last1 || y > last2) {
        if (y > last1 || x > last2) return nums1.length + 1
        res += 1
      }
    })
    res
  }
}
