package leetCode._3200

object Solution_3138 {
  def minAnagramLength(s: String): Int = {
    @scala.annotation.tailrec
    def f(n: Int, res: Int): Int =
      if (n == 0) res
      else if (s.length % n == 0 && s.sliding(n, n).map(_.sorted).toSet.size == 1) f(n - 1, n)
      else f(n - 1, res)

    f(s.length, s.length)
  }
}
