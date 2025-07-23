package leetCode._3600

object Solution_3585 {
  def findMedian(n: Int, edges: Array[Array[Int]], queries: Array[Array[Int]]): Array[Int] = {
    val adj: Array[List[(Int, Int)]] = Array.fill(n)(Nil)

    edges
      .withFilter { case Array(_, _, _) => true; case _ => false }
      .foreach { case Array(u, v, w) =>
        adj(u) = (v, w) :: adj(u)
        adj(v) = (u, w) :: adj(v)
      }

    val LOG = 18
    val parent = Array.ofDim[Int](LOG, n)
    val sumUp = Array.ofDim[Long](LOG, n)
    val depth = Array.ofDim[Int](n)
    val dist = Array.ofDim[Long](n)

    (0 until LOG).foreach(i => (0 until n).foreach(parent(i)(_) = -1))

    def dfs(u: Int, p: Int): Unit = adj(u)
      .withFilter { case (v, _) => v != p }
      .foreach { case (v, w) =>
        parent.head(v) = u
        sumUp.head(v) = w.toLong
        depth(v) = depth(u) + 1
        dist(v) = dist(u) + w
        dfs(v, u)
      }

    dfs(0, -1)

    (1 until LOG).foreach(k => (0 until n)
      .map { v => val mid = parent(k - 1)(v); (v, mid) }
      .withFilter { case (_, mid) => mid >= 0 }
      .foreach { case (v, mid) =>
        parent(k)(v) = parent(k - 1)(mid)
        sumUp(k)(v) = sumUp(k - 1)(v) + sumUp(k - 1)(mid)
      })

    def lca(u0: Int, v0: Int): Int = {
      var u = u0
      var v = v0

      if (depth(u) < depth(v)) {
        val t = u
        u = v
        v = t
      }
      val diff = depth(u) - depth(v)
      (0 until LOG)
        .withFilter(k => ((diff >>> k) & 1) == 1)
        .foreach(k => u = parent(k)(u))

      if (u == v) u
      else {
        ((LOG - 1) to 0 by -1).foreach(k => if (parent(k)(u) != parent(k)(v) && parent(k)(u) != -1 && parent(k)(v) != -1) {
          u = parent(k)(u)
          v = parent(k)(v)
        })
        parent.head(u)
      }
    }

    def climbLess(start: Int, threshold: Long): Int = {
      var cur = start
      var acc = 0L

      ((LOG - 1) to 0 by -1).foreach(k => {
        val nxt = parent(k)(cur)
        if (nxt >= 0 && acc + sumUp(k)(cur) < threshold) {
          acc += sumUp(k)(cur)
          cur = nxt
        }
      })
      cur
    }

    queries.map { case Array(u, v) =>
      if (u == v) u
      else {
        val a = lca(u, v)
        val total = dist(u) + dist(v) - 2 * dist(a)
        val half = if (total % 2 == 0) total / 2 else total / 2 + 1
        val d1 = dist(u) - dist(a)
        if (half <= d1) {
          val z = climbLess(u, half)
          val p0 = parent.head(z)
          if (p0 >= 0) p0 else z
        } else {
          val rem = half - d1
          val d2 = dist(v) - dist(a)
          val t = d2 - rem
          climbLess(v, t + 1)
        }
      }
    }
  }
}
