package leetCode

object Solution_1458 {
  def maxDotProduct(nums1: Array[Int], nums2: Array[Int]): Int = {
    val dp = Array.ofDim[Int](nums1.length + 1, nums2.length + 1)
    var mx = Int.MinValue
    (1 to nums1.length).foreach(i => (1 to nums2.length).foreach(j => {
      mx = mx.max(dp(i - 1)(j - 1) + nums1(i - 1) * nums2(j - 1))
      dp(i)(j) = dp(i)(j - 1).max(dp(i - 1)(j)).max(dp(i - 1)(j - 1) + nums1(i - 1) * nums2(j - 1))
    }))
    mx
  }
}
