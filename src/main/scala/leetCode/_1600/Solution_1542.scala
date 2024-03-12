package leetCode._1600

object Solution_1542 {
  def longestAwesome(s: String): Int = {
    val dp = Array.fill(1 << 10)(Int.MaxValue)
    dp(0) = -1
    var pre = 0
    var mx = 0
    s.indices.foreach(i => {
      pre ^= 1 << (s(i) - '0')
      (0 until 10).foreach(j => {
        val t = 1 << j
        mx = mx.max(i - dp(t ^ pre))
      })
      dp(pre) = i.min(dp(pre))
      mx = mx.max(i - dp(pre))
    })
    mx
  }
}
