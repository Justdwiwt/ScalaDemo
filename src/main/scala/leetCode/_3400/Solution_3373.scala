package leetCode._3400

object Solution_3373 {
  private def buildTree(edges: Array[Array[Int]]): Map[Int, List[Int]] =
    edges.foldLeft(Map.empty[Int, List[Int]])((graph, edge) => {
      val (x, y) = (edge.head, edge(1))
      graph + (x -> (y :: graph.getOrElse(x, Nil))) + (y -> (x :: graph.getOrElse(y, Nil)))
    })

  private def dfs(x: Int, fa: Int, d: Int, g: Map[Int, List[Int]], cnt: Map[Int, Int]): Map[Int, Int] = {
    val updatedCnt = cnt + (d -> (cnt.getOrElse(d, 0) + 1))
    g(x).foldLeft(updatedCnt)((acc, y) => if (y != fa) dfs(y, x, d ^ 1, g, acc) else acc)
  }

  private def dfs1(x: Int, fa: Int, d: Int, g: Map[Int, List[Int]], cnt1: Map[Int, Int], ans: Map[Int, Int]): Map[Int, Int] = {
    val updatedAns = ans + (x -> (ans.getOrElse(x, 0) + cnt1.getOrElse(d, 0)))
    g(x).foldLeft(updatedAns)((acc, y) => if (y != fa) dfs1(y, x, d ^ 1, g, cnt1, acc) else acc)
  }

  def maxTargetNodes(edges1: Array[Array[Int]], edges2: Array[Array[Int]]): Array[Int] = {
    val g2 = buildTree(edges2)
    val g1 = buildTree(edges1)
    val cnt2 = dfs(0, -1, 0, g2, Map(0 -> 0, 1 -> 0))
    val max2 = cnt2.getOrElse(0, 0).max(cnt2.getOrElse(1, 0))
    val cnt1 = dfs(0, -1, 0, g1, Map(0 -> 0, 1 -> 0))
    val initialAns = (0 until edges1.length + 1).map((_, max2)).toMap
    val res = dfs1(0, -1, 0, g1, cnt1, initialAns)
    (0 until edges1.length + 1).map(res.getOrElse(_, 0)).toArray
  }
}
