package leetCode._3500

object Solution_3460 {
  def longestCommonPrefix(s: String, t: String): Int = {
    val m = s.length
    val n = t.length

    def f(i: Int, j: Int, used: Boolean): Int =
      if (i == m || j == n) 0
      else if (s(i) == t(j)) 1 + f(i + 1, j + 1, used)
      else if (used) 0
      else f(i + 1, j, used = true)

    f(0, 0, used = false)
  }
}
