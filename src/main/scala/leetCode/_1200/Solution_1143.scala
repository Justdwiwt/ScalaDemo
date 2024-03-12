package leetCode._1200

object Solution_1143 {
  def longestCommonSubsequence(text1: String, text2: String): Int = {
    if (text1.isEmpty || text2.isEmpty) return 0
    val dp = Array.ofDim[Int](text1.length + 1, text2.length + 1)
    (1 to text1.length).foreach(i => (1 to text2.length).foreach(j => {
      if (text1(i - 1) == text2(j - 1)) dp(i)(j) = dp(i - 1)(j - 1) + 1
      else dp(i)(j) = dp(i - 1)(j).max(dp(i)(j - 1))
    }))
    dp(text1.length)(text2.length)
  }
}
