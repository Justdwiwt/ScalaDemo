package leetCode

object Solution_920 {
  def numMusicPlaylists(n: Int, goal: Int, k: Int): Int = {
    val M = 1000000007
    val dp = Array.ofDim[Long](goal + 1, n + 1)
    dp(0)(0) = 1
    (1 to goal).foreach(i => (1 to n).foreach(j => {
      dp(i)(j) = (dp(i - 1)(j - 1) * (n - j + 1)) % M
      if (j > k) dp(i)(j) = (dp(i)(j) + (dp(i - 1)(j) * (j - k)) % M) % M
    }))
    dp(goal)(n).toInt
  }
}
