package leetCode._1600

object Solution_1577 {
  def numTriplets(nums1: Array[Int], nums2: Array[Int]): Int = {
    val m1 = nums1.map(x => 1L * x * x).groupBy(identity).mapValues(_.length)
    val m2 = nums2.map(x => 1L * x * x).groupBy(identity).mapValues(_.length)
    var res = 0
    nums1.indices.dropRight(1).foreach(i => (i + 1 until nums1.length).foreach(j => {
      val v = 1L * nums1(i) * nums1(j)
      if (m2.contains(v)) res = res + m2(v)
    }))
    nums2.indices.dropRight(1).foreach(i => (i + 1 until nums2.length).foreach(j => {
      val v = 1L * nums2(i) * nums2(j)
      if (m1.contains(v)) res = res + m1(v)
    }))
    res
  }
}
