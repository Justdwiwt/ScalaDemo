package leetCode._3400

object Solution_3372 {
  def maxTargetNodes(edges1: Array[Array[Int]], edges2: Array[Array[Int]], k: Int): Array[Int] = {
    def buildTree(edges: Array[Array[Int]]): Map[Int, List[Int]] =
      edges.foldLeft(Map.empty[Int, List[Int]])((graph, edge) => {
        val (x, y) = (edge.head, edge(1))
        graph + (x -> (y :: graph.getOrElse(x, Nil))) + (y -> (x :: graph.getOrElse(y, Nil)))
      })

    def dfs(x: Int, fa: Int, d: Int, g: Map[Int, List[Int]], k: Int): Int =
      if (d > k) 0
      else 1 + g.getOrElse(x, Nil)
        .filterNot(_ == fa)
        .map(dfs(_, x, d + 1, g, k))
        .sum

    val max2 = if (k > 0) {
      val g2 = buildTree(edges2)
      (0 until edges2.length + 1)
        .map(dfs(_, -1, 0, g2, k - 1))
        .reduceOption(_.max(_))
        .getOrElse(0)
    } else 0

    val g1 = buildTree(edges1)
    (0 until edges1.length + 1)
      .map(dfs(_, -1, 0, g1, k) + max2)
      .toArray
  }
}
