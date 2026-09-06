package leetCode._4000

object Solution_3983 {
  def canMakeSubsequence(s: String, t: String): Boolean = {
    val n = s.length

    if (n > t.length) false
    else t.foldLeft((0, 0)) {
      case ((j0, j1), ch) =>
        val nextJ1 = if (j1 < n && s(j1) == ch) j1 + 1 else j1

        val modifiedJ1 = if (j0 < n) nextJ1.max(j0 + 1) else nextJ1

        val nextJ0 = if (j0 < n && s(j0) == ch) j0 + 1 else j0

        (nextJ0, modifiedJ1)
    }._2 == n
  }
}
