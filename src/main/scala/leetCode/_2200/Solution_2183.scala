package leetCode._2200

object Solution_2183 {
  def countPairs(n: Array[Int], k: Int): Long = n
    .foldLeft(Map.empty[Int, Int].withDefaultValue(0), 0L) { case ((g, r), n) =>
      val cur = gcd(n, k)
      val nextGcd = g.updated(cur, g(cur) + 1)
      val nextRes = g.foldLeft(r) { case (r, (pre, cnt)) => if (cur.toLong * pre % k == 0) r + cnt else r }
      (nextGcd, nextRes)
    }
    ._2

  @scala.annotation.tailrec
  def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
}
