package leetCode

object Solution_349 {
  def intersection(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    nums1.intersect(nums2).distinct
  }
}
