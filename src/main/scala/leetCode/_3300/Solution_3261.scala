package leetCode._3300

object Solution_3261 {
  def countKConstraintSubstrings(S: String, k: Int, queries: Array[Array[Int]]): Array[Long] = {
    val s = S.toCharArray
    val n = s.length
    val right = Array.ofDim[Int](n)
    val sum = Array.ofDim[Long](n + 1)
    val cnt = Array(0, 0)
    var l = 0

    s.indices.foreach(i => {
      cnt(s(i) & 1) += 1
      while (cnt.head > k && cnt(1) > k) {
        cnt(s(l) & 1) -= 1
        right(l) = i
        l += 1
      }
      sum(i + 1) = sum(i) + (i - l + 1)
    })

    right.slice(l, n).indices.foreach(i => right(i + l) = n)

    val res = new Array[Long](queries.length)
    queries.indices.foreach(i => {
      val ql = queries(i).head
      val qr = queries(i)(1)
      val j = right(ql).min(qr + 1)
      res(i) = sum(qr + 1) - sum(j) + (j - ql + 1).toLong * (j - ql) / 2
    })

    res
  }
}
