package leetCode._500

object Solution_459 {
  def repeatedSubstringPattern(s: String): Boolean =
    (s + s).slice(1, s.length * 2 - 1).contains(s)
}
