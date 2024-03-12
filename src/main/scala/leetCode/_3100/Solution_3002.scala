package leetCode._3100

object Solution_3002 {
  def maximumSetSize(nums1: Array[Int], nums2: Array[Int]): Int = {
    val (set1, set2, n) = (nums1.toSet, nums2.toSet, nums1.length)
    val both = set1.count(set2.contains)
    ((set1.size - both).min(n >> 1) + (set2.size - both).min(n >> 1) + both).min(n)
  }
}
