package leetCode._3700

object Solution_3639 {
  def minTime(s: String, order: Array[Int], k: Int): Int = {
    val n = s.length
    val initCnt = n.toLong * (n + 1) / 2
    if (initCnt < k) return -1

    val pre = Array.tabulate(n)(i => i - 1)
    val nxt = Array.tabulate(n)(i => i + 1)

    (n - 1 to 0 by -1).foldLeft((initCnt, -1)) {
        case ((cnt, res), t) if res != -1 => (cnt, res)

        case ((cnt, _), t) =>
          val i = order(t)
          val l = if (i == 0) -1 else pre(i)
          val r = if (i == n - 1) n else nxt(i)

          val newCnt = cnt - (i - l).toLong * (r - i)

          if (l >= 0) nxt(l) = r
          if (r < n) pre(r) = l

          if (newCnt < k) (newCnt, t) else (newCnt, -1)
      }
      ._2
  }
}
