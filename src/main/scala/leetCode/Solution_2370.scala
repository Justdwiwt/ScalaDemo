package leetCode

object Solution_2370 {
  def longestIdealString(s: String, k: Int): Int = {
    val dp = Array.fill(32)(0)
    s.map(_ - 'a').foreach(i => {
      val pre = 0.max(i - k).until(32.min(i + k + 1)).map(dp)
      dp(i) = dp(i).max(pre.max + 1)
    })
    dp.max
  }
}
