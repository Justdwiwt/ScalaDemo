package leetCode._1900

object Solution_1855 {
  def maxDistance(nums1: Array[Int], nums2: Array[Int]): Int = {
    var res = 0
    nums1.indices.foreach(i => while (i + res < nums2.length && nums2(i + res) >= nums1(i)) res += 1)
    if (res == 0) 0 else res - 1
  }
}
