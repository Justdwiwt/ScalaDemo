package leetCode._3000

object Solution_2956 {
  def findIntersectionValues(nums1: Array[Int], nums2: Array[Int]): Array[Int] =
    Array(nums1.count(nums2.contains), nums2.count(nums1.contains))
}
