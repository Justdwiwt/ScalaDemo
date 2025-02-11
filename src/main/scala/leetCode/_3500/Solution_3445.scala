package leetCode._3500

object Solution_3445 {
  def maxDifference(s: String, k: Int): Int = {
    val INF = -1e9.toInt

    def cal(x: Int, y: Int): Int = {
      val n = s.length
      val arr = Array.fill(n + 5, 3, 3)(INF)
      arr(0)(0)(0) = 0
      val m = collection.mutable.Map[Int, Int]()
      (0 until n).foldLeft((0, 0, INF)) { case ((a, b, ret), h) =>
        val i = s(h) - '0'
        val newA = if (i == x) a + 1 else a
        val newB = if (i == y) b + 1 else b
        val p = m.getOrElse(x, 0).min(m.getOrElse(y, 0))
        val newP = if (p > h - k + 1) h - k + 1 else p
        val newRet = if (newA > 0 && newB > 0 && newP >= 0) ret.max(newA - newB + arr(newP)(newA % 2 ^ 1)(newB % 2)) else ret
        arr(h + 1)(newA % 2)(newB % 2) = arr(h + 1)(newA % 2)(newB % 2).max(newB - newA)
        (0 until 2).foreach(j => (0 until 2).foreach(kk => arr(h + 1)(j)(kk) = arr(h + 1)(j)(kk).max(arr(h)(j)(kk))))
        m(i) = h
        (newA, newB, newRet)
      }._3
    }

    (0 to 4).flatMap(i => (0 to 4).map(cal(i, _))).max
  }
}
