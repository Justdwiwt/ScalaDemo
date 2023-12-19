package leetCode

object Solution_2956 {
  def findIntersectionValues(nums1: Array[Int], nums2: Array[Int]): Array[Int] =
    Array(nums1.count(nums2.contains(_)), nums2.count(nums1.contains(_)))
}
