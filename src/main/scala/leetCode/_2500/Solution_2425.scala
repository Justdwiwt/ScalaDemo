package leetCode._2500

object Solution_2425 {
  def xorAllNums(nums1: Array[Int], nums2: Array[Int]): Int = {
    var res = 0
    if (nums2.length % 2 != 0) nums1.foreach(res ^= _)
    if (nums1.length % 2 != 0) nums2.foreach(res ^= _)
    res
  }
}
