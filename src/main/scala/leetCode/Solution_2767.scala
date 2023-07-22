package leetCode

object Solution_2767 {
  def minimumBeautifulSubstrings(s: String): Int = {
    val dp = Array.fill(s.length + 1)(s.length + 1)
    dp(0) = 0
    s
      .indices
      .withFilter(i => s.charAt(i) != '0')
      .foreach(i => (i until s.length)./:(0)((cur, j) => {
        val t = cur * 2 + s.charAt(j) - '0'
        if (15625 % t == 0) dp(j + 1) = dp(j + 1).min(dp(i) + 1)
        t
      }))
    if (dp(s.length) > s.length) -1 else dp(s.length)
  }
}
