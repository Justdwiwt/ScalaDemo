package leetCode

object Solution_44 {
  def isMatch(s: String, p: String): Boolean = {
    val str = s.toArray
    val pattern = p.toArray

    val n = str.length
    val m = pattern.length
    val dp = Array.fill(n + 1, m + 1)(false)
    dp(0)(0) = true

    @scala.annotation.tailrec
    def f(i: Int): Unit = {
      if (i <= m && pattern(i - 1) == '*') {
        dp(0)(i) = true
        f(i + 1)
      }
    }

    f(1)

    (1 to n).foreach(i =>
      (1 to m).foreach(j => {
        if (str(i - 1) == pattern(j - 1) || pattern(j - 1) == '?')
          dp(i)(j) = dp(i - 1)(j - 1)
        if (pattern(j - 1) == '*')
          dp(i)(j) = dp(i - 1)(j) || dp(i)(j - 1) || dp(i - 1)(j - 1)
      })
    )
    dp(n)(m)
  }
}
