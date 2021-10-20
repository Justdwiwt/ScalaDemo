package leetCode

object Offer_094 {
  def minCut(s: String): Int = {
    val dp = Array.fill(s.length + 1)(0)
    var j = 0
    (0 to s.length).foreach(i => dp(i) = i - 1)
    s.indices.foreach(i => {
      j = 0
      while (i - j >= 0 && i + j < s.length && s(i - j) == s(i + j)) {
        dp(i + j + 1) = dp(i + j + 1).min(1 + dp(i - j))
        j += 1
      }
      j = 1
      while (i - j + 1 >= 0 && i + j < s.length && s(i - j + 1) == s(i + j)) {
        dp(i + j + 1) = dp(i + j + 1).min(1 + dp(i - j + 1))
        j += 1
      }
    })
    dp(s.length)
  }
}
