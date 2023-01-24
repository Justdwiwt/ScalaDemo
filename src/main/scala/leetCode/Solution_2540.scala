package leetCode

object Solution_2540 {
  def getCommon(nums1: Array[Int], nums2: Array[Int]): Int = {
    val res = nums1.intersect(nums2)
    if (res.isEmpty) -1 else res.min
  }
}
