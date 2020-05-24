package leetCode

object Solution_940 {
  def distinctSubseqII(S: String): Int = {
    val M = 1000000007
    val dp = Array.fill(S.length + 1)(0)
    val pos = Array.fill(128)(-1)
    S.indices.foreach(i => {
      if (pos(S(i)) < 0) dp(i + 1) = dp(i) + dp(i) + 1
      else {
        dp(i + 1) = dp(i) + dp(i) - dp(pos(S(i)))
        if (dp(i + 1) < 0) dp(i + 1) += M
      }
      dp(i + 1) %= M
      pos(S(i)) = i
    })
    dp(S.length)
  }
}
