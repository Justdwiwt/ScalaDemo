package leetCode

object Solution_1750 {
  def minimumLength(s: String): Int = {
    var (l, r) = (0, s.length - 1)
    while (l < r) {
      if (s(l) != s(r)) return r - l + 1
      while (l < r && s(l) == s(r)) l += 1
      while (r >= l && s(l - 1) == s(r)) r -= 1
    }
    r - l + 1
  }
}
