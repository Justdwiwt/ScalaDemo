package leetCode._1500

object Solution_1443 {
  def minTime(n: Int, edges: Array[Array[Int]], _hasApple: List[Boolean]): Int = {
    val graph = edges.foldLeft(Map.empty[Int, Seq[Int]].withDefaultValue(Seq.empty)) { case (graph, Array(a, b)) =>
      graph.updated(a, graph(a) :+ b).updated(b, graph(b) :+ a)
    }
    val appleNodes = _hasApple.zipWithIndex.collect { case (has, node) if has => node }.toSet

    def dfs(node: Int, parent: Int): Int = {
      val childCost = graph(node).filter(_ != parent).map(dfs(_, node)).sum
      if (childCost > 0 || appleNodes.contains(node)) 2 + childCost else 0
    }

    (dfs(0, -1) - 2).max(0)
  }
}
