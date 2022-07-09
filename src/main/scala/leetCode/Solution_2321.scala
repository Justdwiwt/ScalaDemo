package leetCode

object Solution_2321 {
  def maximumsSplicedArray(nums1: Array[Int], nums2: Array[Int]): Int = {
    def f(nums1: Array[Int], nums2: Array[Int]): Int = nums1
      .indices
      .scanLeft(0)((sum, i) => (sum + nums2(i) - nums1(i)).max(nums2(i) - nums1(i)))
      .max

    (nums1.sum + f(nums1, nums2)).max(nums2.sum + f(nums2, nums1))
  }
}
