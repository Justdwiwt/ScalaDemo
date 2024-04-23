package leetCode._2200

object Solution_2143 {
  def countSubranges(nums1: Array[Int], nums2: Array[Int]): Int = {
    val n = nums1.length
    var s1 = 0
    var s2 = 0
    val M = (1e9 + 7).toInt

    nums1.indices.foreach(i => {
      s1 += nums1(i)
      s2 += nums2(i)
    })

    val base = s1.max(s2)
    val arr = Array.fill(n, 2 * base + 1)(0)
    arr.head(base + nums1.head) += 1
    arr.head(base - nums2.head) += 1
    var res = 0

    nums1.indices.drop(1).foreach(i => (0 to 2 * base).foreach(j => {
      if (nums1(i) + base == j)
        arr(i)(j) += 1
      if (-nums2(i) + base == j)
        arr(i)(j) += 1
      if (j - nums1(i) >= 0)
        arr(i)(j) = (arr(i)(j) % M + arr(i - 1)(j - nums1(i)) % M) % M
      if (j + nums2(i) <= 2 * base)
        arr(i)(j) = (arr(i)(j) % M + arr(i - 1)(j + nums2(i)) % M) % M
    }))

    nums1.indices.foreach(i => res = (res % M + arr(i)(base) % M) % M)
    res
  }
}
