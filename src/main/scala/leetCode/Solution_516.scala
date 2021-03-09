package leetCode

object Solution_516 {
  def longestPalindromeSubseq(s: String): Int = {
    val dp = Array.fill(s.length, s.length)(0)
    s.indices.foreach(i => dp(i)(i) = 1)
    s.indices.reverse.foreach(i => (i + 1 until s.length).foreach(j =>
      if (s(i) == s(j)) dp(i)(j) = dp(i + 1)(j - 1) + 2
      else dp(i)(j) = dp(i + 1)(j).max(dp(i)(j - 1))))
    dp.head(s.length - 1)
  }
}
