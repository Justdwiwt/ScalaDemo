package leetCode._3500

object Solution_3472 {
  def longestPalindromicSubsequence(s: String, k: Int): Int = {
    val n = s.length
    val arr = s.map(_.toInt)
    val m = collection.mutable.Map[(Int, Int, Int), Int]()

    def dfs(i: Int, j: Int, k: Int): Int = {
      if (i >= j) return j - i + 1
      m.get((i, j, k)) match {
        case Some(res) => res
        case None =>
          var res = dfs(i + 1, j, k).max(dfs(i, j - 1, k))
          val d = (arr(i) - arr(j)).abs
          val op = d.min(26 - d)
          if (op <= k) res = res.max(dfs(i + 1, j - 1, k - op) + 2)
          m((i, j, k)) = res
          res
      }
    }

    dfs(0, n - 1, k)
  }
}
