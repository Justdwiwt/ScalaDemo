package leetCode._3800

object Solution_3748 {
  def countStableSubarrays(
                            nums: Array[Int],
                            queries: Array[Array[Int]]
                          ): Array[Long] = {

    val n = nums.length
    val s = new Array[Long](n + 1)
    var cnt = 0
    nums.indices.foreach(i => {
      if (i > 0 && nums(i) < nums(i - 1)) cnt = 0
      cnt += 1
      s(i + 1) = s(i) + cnt
    })

    val nxt = new Array[Int](n)
    nxt(n - 1) = n
    (n - 2 to 0 by -1).foreach(i => if (nums(i) <= nums(i + 1)) nxt(i) = nxt(i + 1) else nxt(i) = i + 1)

    val ans = new Array[Long](queries.length)
    queries.indices.foreach(i => {
      val l = queries(i)(0)
      val r = queries(i)(1)
      val l2 = nxt(l)
      if (l2 > r) {
        val m = r - l + 1
        ans(i) = m.toLong * (m + 1) / 2
      } else {
        val m = l2 - l
        ans(i) = m.toLong * (m + 1) / 2 + s(r + 1) - s(l2)
      }
    })
    ans
  }
}
