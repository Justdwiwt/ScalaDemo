package leetCode._1800

object Solution_1771 {
  def longestPalindrome(word1: String, word2: String): Int = {
    val str = word1 + word2
    val dp = Array.ofDim[Int](str.length + 1, str.length)
    var res = 0
    dp.head.indices.foreach(i => dp(1)(i) = 1)
    (2 to str.length).foreach(i => (0 to dp.head.length - i).foreach(j => {
      if (str(j) == str(j + i - 1)) {
        dp(i)(j) = dp(i - 2)(j + 1) + 2
        if (j < word1.length && j + i > word1.length) res = res.max(dp(i)(j))
      }
      dp(i)(j) = dp(i)(j).max(dp(i - 1)(j).max(dp(i - 1)(j + 1)))
    }))
    res
  }
}
