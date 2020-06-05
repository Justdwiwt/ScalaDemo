package leetCode

object Solution_1420 {
  def numOfArrays(n: Int, m: Int, k: Int): Int = {
    val mod = (1e9 + 7).toInt
    val dp = Array.ofDim[Int](51, 101, 51)
    var M = 0
    var K = 0

    def dfs(pos: Int, ma: Int, k: Int): Int = {
      if (pos == -1) {
        if (k == K) return 1
        return 0
      }
      if (k > K) return 0
      if (dp(pos)(ma)(k) != -1) return dp(pos)(ma)(k)
      var t = 0
      (1 to M).foreach(i => t = if (i > ma) (t + dfs(pos - 1, i, k + 1)) % mod else (t + dfs(pos - 1, ma, k)) % mod)
      dp(pos)(ma)(k) = t
      t
    }

    M = m
    K = k
    dp.foreach(i => i.foreach(j => j.indices.foreach(k => j(k) = -1)))
    dfs(n - 1, 0, 0)
  }
}
