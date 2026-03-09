package leetCode._3900

object Solution_3844 {
  def almostPalindromic(s: String): Int = {
    val n = s.length

    def f(l: Int, r: Int, buff: Boolean): Boolean =
      if (l >= r) true
      else if (s(l) == s(r)) f(l + 1, r - 1, buff)
      else if (buff) {
        if (l + 1 == r) true
        else if (s(l + 1) == s(r) && s(l) == s(r - 1))
          f(l, r - 1, buff = false) || f(l + 1, r, buff = false)
        else if (s(l + 1) == s(r)) f(l + 1, r, buff = false)
        else if (s(l) == s(r - 1)) f(l, r - 1, buff = false)
        else false
      } else false

    Iterator
      .from(n, -1)
      .takeWhile(_ > 0)
      .find(k => (0 to n - k).exists(i => f(i, i + k - 1, buff = true)))
      .getOrElse(0)
  }
}
