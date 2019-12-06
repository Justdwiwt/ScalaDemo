package leetCode

object Solution_712 {
  def minimumDeleteSum(s1: String, s2: String): Int = {
    var sum = 0
    s1.foreach(i => sum += i)
    s2.foreach(i => sum += i)
    val dp = Array.fill(s2.length)(0)
    s1.foreach(c => {
      var last = dp(0)
      if (c == s2(0)) dp(0) = c
      (1 until s2.length).foreach(i => {
        val t = last
        last = dp(i)
        if (c == s2(i)) dp(i) = t + c else if (dp(i - 1) > dp(i)) dp(i) = dp(i - 1)
      })
    })
    sum - 2 * dp(s2.length - 1)
  }
}
