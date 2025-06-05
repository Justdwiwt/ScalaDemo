package leetCode._3600

object Solution_3553 {
  def minimumWeight(edges: Array[Array[Int]], queries: Array[Array[Int]]): Array[Int] = {
    val g = new LcaBinaryLifting(edges)
    queries.map { case Array(a, b, c) => (g.getDis(a, b) + g.getDis(b, c) + g.getDis(a, c)) / 2 }
  }

  private class LcaBinaryLifting(edges: Array[Array[Int]]) {
    private val n = edges.length + 1
    private val m = 32 - Integer.numberOfLeadingZeros(n)
    private val graph = Array.fill(n)(List.empty[(Int, Int)])

    edges.foreach { case Array(u, v, w) =>
      graph(u) ::= (v, w)
      graph(v) ::= (u, w)
    }

    private val depth = Array.fill(n)(0)
    private val dist = Array.fill(n)(0)
    private val pa = Array.fill(n, m)(-1)

    private def dfs(x: Int, father: Int): Unit = {
      pa(x)(0) = father
      graph(x)
        .withFilter { case (y, _) => y != father }
        .foreach { case (y, w) =>
          depth(y) = depth(x) + 1
          dist(y) = dist(x) + w
          dfs(y, x)
        }
    }

    dfs(0, -1)

    (0 until m - 1).foreach(i => (0 until n).foreach(x => {
      val p = pa(x)(i)
      if (p != -1) pa(x)(i + 1) = pa(p)(i)
    }))

    private def getKthAncestor(node: Int, k: Int): Int = {
      var cur = node
      var remain = k
      var i = 0
      while (remain > 0) {
        if ((remain & 1) != 0) cur = pa(cur)(i)
        remain >>= 1
        i += 1
      }
      cur
    }

    private def getLca(x: Int, y: Int): Int = {
      var a = x
      var b = y
      if (depth(a) > depth(b)) {
        val tmp = a
        a = b
        b = tmp
      }
      b = getKthAncestor(b, depth(b) - depth(a))
      if (a == b) return a
      (m - 1 to 0 by -1).foreach(i => if (pa(a)(i) != -1 && pa(a)(i) != pa(b)(i)) {
        a = pa(a)(i)
        b = pa(b)(i)
      })
      pa(a)(0)
    }

    def getDis(x: Int, y: Int): Int =
      dist(x) + dist(y) - 2 * dist(getLca(x, y))
  }
}
