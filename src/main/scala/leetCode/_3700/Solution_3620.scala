package leetCode._3700

object Solution_3620 {
  def findMaxPathScore(edges: Array[Array[Int]], online: Array[Boolean], k: Long): Int = {
    val n = online.length
    val g = Array.fill(n)(List.empty[(Int, Int)])
    var maxWeight = -1

    edges
      .withFilter { case Array(_, _, _) => true; case _ => false }
      .withFilter { case Array(x, y, _) => online(x) && online(y) }
      .foreach { case Array(x, y, wt) =>
        g(x) = (y, wt) :: g(x)
        if (x == 0) maxWeight = math.max(maxWeight, wt)
      }

    def check(lower: Int): Boolean = {
      val memo = collection.mutable.Map.empty[Int, Long]

      def dfs(x: Int): Long = {
        if (x == n - 1) return 0L
        if (memo.contains(x)) return memo(x)
        var res = Long.MaxValue
        g(x)
          .withFilter { case (_, wt) => wt >= lower }
          .foreach { case (y, wt) =>
            val cost = dfs(y)
            if (cost != Long.MaxValue) res = math.min(res, cost + wt)
          }
        memo(x) = res
        res
      }

      dfs(0) > k
    }

    var l = 0
    var r = maxWeight + 1
    while (l < r) {
      val m = (l + r) / 2
      if (check(m)) r = m
      else l = m + 1
    }
    l - 1
  }
}
