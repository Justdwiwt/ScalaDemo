package leetCode

object Solution_1682 {
  def longestPalindromeSubseq(s: String): Int = {
    var dp = Array.fill(s.length, s.length, 2)(0)
    (s.length - 2 to 0 by (-1)).foreach(i => (i + 1 until s.length).foreach(j => {
      if (s(i) == s(j) && s(i) != dp(i + 1)(j - 1)(1)) {
        dp(i)(j)(0) = dp(i + 1)(j - 1).head + 2
        dp(i)(j)(1) = s(i).toInt
      } else {
        if (dp(i + 1)(j).head > dp(i)(j - 1).head) dp(i)(j) = dp(i + 1)(j)
        else dp(i)(j) = dp(i)(j - 1)
      }
    }))
    dp.head(s.length - 1).head
  }
}
