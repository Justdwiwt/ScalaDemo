package leetCode._1900

object Solution_1885 {
  def countPairs(nums1: Array[Int], nums2: Array[Int]): Long = {
    val n = nums1.length

    nums1.indices.foreach(i => nums1(i) -= nums2(i))
    val sorted = nums1.sorted

    var l = 0
    var r = n - 1
    var res = 0L

    while (l < r) {
      if (sorted(l) + sorted(r) > 0) {
        res += r - l
        r -= 1
      } else l += 1
    }

    res
  }
}
