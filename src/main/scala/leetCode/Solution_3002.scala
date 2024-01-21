package leetCode

object Solution_3002 {
  def maximumSetSize(nums1: Array[Int], nums2: Array[Int]): Int = {
    val half = nums1.length / 2
    val s1 = nums1.toSet
    val s2 = nums2.toSet
    var cnt1 = s1.size
    var cnt2 = s2.size
    s1.foreach(i => {
      if (s2.contains(i) && cnt2 >= cnt1) cnt2 -= 1
      else if (s2.contains(i) && cnt1 >= cnt2) cnt1 -= 1
    })
    if (cnt1 > half) cnt1 = half
    if (cnt2 > half) cnt2 = half
    cnt1 + cnt2
  }
}
