package leetCode._3400

object Solution_3316 {
  def maxRemovals(source: String, pattern: String, targetIndices: Array[Int]): Int = {
    val s = source.toCharArray
    val p = pattern.toCharArray
    val m = s.length
    val n = p.length
    val set = targetIndices.toSet
    val dp = Array.fill(m, n)(-1)

    def dfs(i: Int, j: Int): Int = {
      if (i >= m) return if (j >= n) 0 else Int.MinValue
      if (j >= n) return dfs(i + 1, j) + (if (set.contains(i)) 1 else 0)
      if (dp(i)(j) != -1) return dp(i)(j)

      val res = if (s(i) == p(j)) {
        val notDelete = dfs(i + 1, j + 1)
        val delete = if (set.contains(i)) dfs(i + 1, j) + 1 else Int.MinValue
        notDelete.max(delete)
      } else {
        val notDelete = dfs(i + 1, j)
        val delete = if (set.contains(i)) dfs(i + 1, j) + 1 else Int.MinValue
        notDelete.max(delete)
      }

      dp(i)(j) = res
      res
    }

    dfs(0, 0)
  }
}
