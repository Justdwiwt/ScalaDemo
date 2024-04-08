package leetCode._200

object Solution_132 {
  def minCut(s: String): Int = {
    val n = s.length
    val arr = Array.fill(n, n)(false)
    val cuts = s.indices.foldLeft(Array.tabulate(n)(i => i))((a, j) => (0 to j).foldLeft(a)((cur, i) => {
      if (s(i) == s(j) && (j - i <= 1 || arr(i + 1)(j - 1))) {
        arr(i)(j) = true
        cur.updated(j, if (i == 0) 0 else cur(j).min(cur(i - 1) + 1))
      } else cur
    }))
    cuts(n - 1)
  }
}
