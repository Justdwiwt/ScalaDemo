package leetCode._2100

object Solution_2040 {
  def kthSmallestProduct(nums1: Array[Int], nums2: Array[Int], k: Long): Long = {
    val (neg1, pos1) = nums1.partition(_ < 0)
    val (neg2, pos2) = nums2.partition(_ < 0)

    var (l, r) = (Long.MinValue, Long.MaxValue)
    while (l < r) {
      val m = (l + r) >> 1
      var cur = 0L

      var j = pos2.length - 1
      pos1.indices.foreach(i => {
        while (j >= 0 && 1L * pos1(i) * pos2(j) > m) j -= 1
        cur += j + 1
      })

      var j2 = 0
      neg1.indices.foreach(i => {
        while (j2 < pos2.length && 1L * neg1(i) * pos2(j2) > m) j2 += 1
        cur += pos2.length - j2
      })

      var j3 = 0
      pos1.indices.foreach(i => {
        while (j3 < neg2.length && 1L * pos1(i) * neg2(j3) <= m) j3 += 1
        cur += j3
      })

      var j4 = neg2.length - 1
      neg1.indices.foreach(i => {
        while (j4 >= 0 && 1L * neg1(i) * neg2(j4) <= m) j4 -= 1
        cur += neg2.length - 1 - j4
      })

      if (cur < k) l = m + 1
      else r = m
    }

    l
  }
}
