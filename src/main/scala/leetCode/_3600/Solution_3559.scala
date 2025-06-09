package leetCode._3600

object Solution_3559 {
  val M = 1000000007

  def assignEdgeWeights(edges: Array[Array[Int]], queries: Array[Array[Int]]): Array[Int] = {
    val n = edges.length + 1
    val graph = Array.fill(n + 1)(List[Int]())
    edges
      .withFilter { case Array(_, _) => true; case _ => false }
      .foreach { case Array(u, v) =>
        graph(u) ::= v
        graph(v) ::= u
      }
    val depth = Array.fill(n + 1)(0)
    val parent = Array.fill(n + 1)(0)

    def dfs(node: Int, par: Int): Unit = {
      parent(node) = par
      graph(node)
        .withFilter(_ != par)
        .foreach(nei => {
          depth(nei) = depth(node) + 1
          dfs(nei, node)
        })
    }

    dfs(1, 0)

    def lca(u: Int, v: Int): Int = {
      var a = u
      var b = v
      while (depth(a) > depth(b)) a = parent(a)
      while (depth(b) > depth(a)) b = parent(b)
      while (a != b) {
        a = parent(a)
        b = parent(b)
      }
      a
    }

    def power(base: Long, exp: Int): Int = {
      var res = 1L
      var b = base
      var e = exp
      while (e > 0) {
        if ((e & 1) == 1) res = (res * b) % M
        b = (b * b) % M
        e >>= 1
      }
      res.toInt
    }

    queries.map { case Array(u, v) =>
      if (u == v) 0
      else {
        val l = lca(u, v)
        val pathLen = depth(u) + depth(v) - 2 * depth(l)
        power(2, pathLen - 1)
      }
    }
  }
}
