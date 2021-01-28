package leetCode

object Solution_1723 {
  def minimumTimeRequired(jobs: Array[Int], k: Int): Int = {
    if (k == 1) return jobs.sum
    if (k == jobs.length) return jobs.max
    val N = 1 << jobs.length
    val costs = Array.fill(N)(0)
    costs(1) = jobs(0)
    jobs.indices.drop(1).foreach(i => (0 until 1 << i).foreach(j => costs(j + (1 << i)) = costs(j) + jobs(i)))
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
