package leetCode

object Solution_2215 {
  def findDifference(nums1: Array[Int], nums2: Array[Int]): List[List[Int]] =
    List(nums1.toSet.diff(nums2.toSet).toList, nums2.toSet.diff(nums1.toSet).toList)
}
