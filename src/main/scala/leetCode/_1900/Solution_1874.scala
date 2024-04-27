package leetCode._1900

object Solution_1874 {
  def minProductSum(nums1: Array[Int], nums2: Array[Int]): Int = {
    val sortedNums1 = nums1.sorted
    val sortedNums2 = nums2.sorted.reverse

    (sortedNums1, sortedNums2).zipped.map(_ * _).sum
  }
}
