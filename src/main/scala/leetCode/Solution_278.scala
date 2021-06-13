package leetCode

object Solution_278 {
  def isBadVersion(version: Int): Boolean = ???

  def firstBadVersion(n: Int): Int = {
    @annotation.tailrec
    def f(res: Int, low: Int, high: Int): Int = {
      val m = (high - low) / 2 + low
      if (low > high) res
      else if (isBadVersion(m)) f(res.min(m), low, m - 1)
      else f(res, m + 1, high)
    }

    f(n, 1, n)
  }
}
