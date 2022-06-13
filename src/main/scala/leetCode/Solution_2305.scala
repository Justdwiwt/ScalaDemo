package leetCode

object Solution_2305 {
  def distributeCookies(cookies: Array[Int], k: Int): Int = {
    if (k == 1) return cookies.sum
    if (k == cookies.length) return cookies.max
    val N = 1 << cookies.length
    val costs = Array.fill(N)(0)
    costs(1) = cookies(0)
    cookies.indices.drop(1).foreach(i => (0 until 1 << i).foreach(j => costs(j + (1 << i)) = costs(j) + cookies(i)))
    val dp = Array.fill(k + 1, N)(0)
    dp(1) = costs
    (2 to k).foreach(w => (1 until N).foreach(state => {
      dp(w)(state) = dp(w - 1)(state)
      var subset = state
      while (subset > 0) {
        subset = (subset - 1) & state
        val maxCost = dp(w - 1)(state - subset).max(costs(subset))
        dp(w)(state) = dp(w)(state).min(maxCost)
      }
    }))
    dp(k)(N - 1)
  }
}
