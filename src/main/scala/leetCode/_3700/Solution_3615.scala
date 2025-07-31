package leetCode._3700

object Solution_3615 {
  def maxLen(n: Int, edges: Array[Array[Int]], label: String): Int = {
    val cnt = label.groupBy(identity).mapValues(_.length)
    val odd = cnt.values.count(_ % 2 == 1)
    val theoreticalMax = n - math.max(odd - 1, 0)

    if (edges.length == n * (n - 1) / 2) theoreticalMax else {
      val g = Array.fill(n)(collection.mutable.ArrayBuffer.empty[Int])
      edges.foreach { case Array(x, y) =>
        g(x).append(y)
        g(y).append(x)
      }

      val memo = collection.mutable.Map.empty[(Int, Int, Int), Int]

      def dfs(x: Int, y: Int, vis: Int): Int = {
        val key = (x, y, vis)
        memo.getOrElseUpdate(key, {
          var maxLen = 0
          g(x)
            .withFilter(v => (vis >> v & 1) == 0)
            .foreach(v => g(y)
              .withFilter(w => (vis >> w & 1) == 0 && v != w && label(v) == label(w))
              .foreach(w => {
                val (tv, tw) = if (v < w) (v, w) else (w, v)
                maxLen = math.max(maxLen, dfs(tv, tw, vis | (1 << v) | (1 << w)) + 2)
              }))
          maxLen
        })
      }

      var best = 0
      var found = false

      (0 until n)
        .withFilter(_ => !found)
        .foreach(x => {
          val oddLen = dfs(x, x, 1 << x) + 1
          if (oddLen == theoreticalMax) {
            best = oddLen
            found = true
          } else {
            var localMax = oddLen
            g(x)
              .withFilter(y => x < y && label(x) == label(y))
              .foreach(y => {
                val evenLen = dfs(x, y, (1 << x) | (1 << y)) + 2
                if (evenLen == theoreticalMax) {
                  best = evenLen
                  found = true
                }
                localMax = math.max(localMax, evenLen)
              })
            best = math.max(best, localMax)
          }
        })

      if (!found) (0 until n).foreach(x => {
        val oddLen = dfs(x, x, 1 << x) + 1
        var evenMax = 0
        g(x)
          .withFilter(y => x < y && label(x) == label(y))
          .foreach(y => evenMax = math.max(evenMax, dfs(x, y, (1 << x) | (1 << y)) + 2))
        best = math.max(best, math.max(oddLen, evenMax))
      })

      best
    }
  }
}
