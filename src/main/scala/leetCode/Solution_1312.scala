package leetCode

object Solution_1312 {
  def minInsertions(s: String): Int = {
    val dp = Array.fill(s.length)(Array.fill(s.length)(0))
    s.indices.reverse.foreach(i => (i + 1 until s.length).foreach(j => {
      dp(i)(j) = 1 + dp(i + 1)(j).min(dp(i)(j - 1))
      if (s(i) == s(j)) dp(i)(j) = dp(i)(j).min(dp(i + 1)(j - 1))
    }))
    dp(0)(s.length - 1)
  }
}
