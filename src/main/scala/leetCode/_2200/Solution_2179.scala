package leetCode._2200

object Solution_2179 {
  def goodTriplets(nums1: Array[Int], nums2: Array[Int]): Long = {
    val n = nums1.length
    val p = Array.fill(n)(0)
    nums1.zipWithIndex.foreach { case (num, index) => p(num) = index }
    var res = 0L
    val tree = Array.fill(n + 1)(0)
    (1 until n - 1)
      .foreach(i => {
        var j = p(nums2(i - 1)) + 1
        while (j <= n) {
          tree(j) += 1
          j += j & -j
        }
        val y = p(nums2(i))
        var less = 0
        var k = y
        while (k > 0) {
          less += tree(k)
          k &= k - 1
        }
        res += less.toLong * (n - 1 - y - (i - less))
      })
    res
  }
}
