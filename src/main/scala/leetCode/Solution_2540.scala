package leetCode

object Solution_2540 {
  def getCommon(nums1: Array[Int], nums2: Array[Int]): Int = {
    var i, j = 0
    while (i < nums1.length && j < nums2.length) {
      if (nums1(i) < nums2(j)) i += 1
      else if (nums1(i) == nums2(j)) return nums1(i)
      else j += 1
    }
    -1
  }
}
