package leetCode

object Solution_32 {
  def longestValidParentheses(s: String): Int = {
    val dp = Array.fill(s.length)(0)
    var p = -2
    var res = 0
    var k = -2
    s.indices.foreach(i => {
      if (s(i) == '(') {
        if (p == -2) {
          k = i - 1
          dp(i) = k
        } else dp(i) = p
        p = i
      } else if (p > k) {
        p = dp(p)
        res = res.max(i - p)
      } else p = -2
    })
    res
  }
}
