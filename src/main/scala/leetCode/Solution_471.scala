package leetCode

object Solution_471 {
  def encode(s: String): String = {
    val dp = Array.ofDim[String](s.length, s.length)
    (1 to s.length).foreach(len => (0 until s.length + 1 - len).foreach(i => {
      val j = i + len - 1
      dp(i)(j) = f(s, i, j)
      (i until j).foreach(k => {
        val t = dp(i)(k) + dp(k + 1)(j)
        if (dp(i)(j).length > t.length) dp(i)(j) = t
      })
    }))

    def f(s: String, i: Int, j: Int): String = {
      val t = s.substring(i, j + 1)
      if (t.length < 5) return t
      val p = (t + t).indexOf(t, 1)
      if (p != t.length) {
        val cnt = t.length / p
        return cnt + "[" + dp(i)(i + p - 1) + "]"
      }
      t
    }

    dp.head(s.length - 1)
  }
}
