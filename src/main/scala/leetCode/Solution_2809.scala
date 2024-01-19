package leetCode

object Solution_2809 {
  def minimumTime(nums1: List[Int], nums2: List[Int], x: Int): Int = {
    val n = nums1.length
    val arr = Array.fill(n, 2)(0)
    var s1, s2 = 0
    nums1.indices.foreach(i => {
      arr(i)(0) = nums1(i)
      arr(i)(1) = nums2(i)
      s1 += arr(i).head
      s2 += arr(i)(1)
    })
    if (s1 <= x) return 0
    val sorted = arr.sorted((i: Array[Int], j: Array[Int]) => i(1) - j(1))
    val dp = Array.fill(n, n + 1)(0)
    (1 to n).foreach(j => {
      (j - 1 until n).foreach(i => {
        if (i == 1) dp(i)(j) = dp(i - 1)(j - 1)
        else if (i > 1) dp(i)(j) = dp(i - 1)(j - 1).max(dp(i - 1)(j) - sorted(i - 1).head - j * sorted(i - 1)(1))
        dp(i)(j) += sorted(i).head + j * sorted(i)(1)
        if (s1 + j * s2 - dp(i)(j) <= x) return j
      })
    })
    -1
  }
}
