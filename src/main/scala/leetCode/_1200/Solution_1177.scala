package leetCode._1200

object Solution_1177 {
  def canMakePaliQueries(s: String, queries: Array[Array[Int]]): Array[Boolean] = {
    val arr = s.toArray
    val t = Array.fill(s.length + 1)(Array.fill(26)(0))
    (1 to s.length).foreach(i => (0 until 26).foreach(j => {
      if (arr(i - 1) - 'a' == j) t(i)(j) = 1 + t(i - 1)(j)
      else t(i)(j) = t(i - 1)(j)
    }))

    def f(l: Int, r: Int, k: Int): Boolean = t(r + 1)
      .zip(t(l))
      .count { case (x, y) => (y - x) % 2 != 0 } / 2 <= k

    queries.map { case Array(l, r, k) => if (k >= 26) true else f(l, r, k) }
  }
}
