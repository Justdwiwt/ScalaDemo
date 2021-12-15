package leetCode

object Solution_2032 {
  def twoOutOfThree(nums1: Array[Int], nums2: Array[Int], nums3: Array[Int]): List[Int] = {
    (nums1.toSet & nums2.toSet | nums2.toSet & nums3.toSet | nums3.toSet & nums1.toSet).toList
  }
}
