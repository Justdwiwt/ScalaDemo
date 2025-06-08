package leetCode._3600

object Solution_3558 {
  val M: Int = 1000000007

  def assignEdgeWeights(edges: Array[Array[Int]]): Int = {
    val n = edges.length + 1
    val emptyGraph = Vector.fill(n + 1)(List.empty[Int])
    val g = edges.foldLeft(emptyGraph)((graph, edge) => {
      val x = edge(0)
      val y = edge(1)
      graph.updated(x, y :: graph(x)).updated(y, x :: graph(y))
    })

    def dfs(x: Int, fa: Int): Int = g(x)
      .filter(_ != fa)
      .map(dfs(_, x) + 1)
      .foldLeft(0)(math.max)

    val k = dfs(1, 0)
    if (k == 0) 1 else modPow(2, k - 1, M)
  }

  private def modPow(base: Int, exp: Int, mod: Int): Int = {
    @scala.annotation.tailrec
    def loop(b: Long, e: Int, acc: Long): Long = {
      if (e == 0) acc
      else if ((e & 1) == 1) loop((b * b) % mod, e >> 1, (acc * b) % mod)
      else loop((b * b) % mod, e >> 1, acc)
    }

    loop(base.toLong, exp, 1L).toInt
  }
}
