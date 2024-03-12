package leetCode._400

object Solution_392 {
  def isSubsequence(s: String, t: String): Boolean =
    t./:(0)((idx, ch) => if (idx < s.length && ch == s(idx)) idx + 1 else idx) == s.length
}
