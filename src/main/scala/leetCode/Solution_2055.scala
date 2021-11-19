package leetCode

object Solution_2055 {
  def platesBetweenCandles(s: String, queries: Array[Array[Int]]): Array[Int] = {
    val prev = s.indices.scan(0)((cur, idx) => if (s(idx) == '|') idx else cur)
    val next = s.indices.scanRight(s.length)((idx, cur) => if (s(idx) == '|') idx else cur)
    val cnt = s.map(c => if (c == '|') 1 else 0).scan(0)(_ + _)
    queries.map({ case Array(l, r) =>
      val n = next(l)
      val p = prev(r + 1)
      if (p >= n) p - n - cnt(p + 1) + cnt(n + 1) else 0
    })
  }
}
