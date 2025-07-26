package leetCode._3600

object Solution_3593 {
  def minIncrease(n: Int, edges: Array[Array[Int]], cost: Array[Int]): Int = {
    val graph: Map[Int, List[Int]] = edges.foldLeft(Map.empty[Int, List[Int]].withDefaultValue(Nil)) {
      case (m, Array(u, v)) =>
        m.updated(u, v :: m(u)).updated(v, u :: m(v))
    }

    def dfs(node: Int, parent: Int): (Int, Int) = {
      val children = graph(node).filter(_ != parent)
      if (children.isEmpty) return (cost(node), 0)

      val results: List[(Int, Int)] = children.map(dfs(_, node))
      val maxSum = results.map(_._1).max
      val totalOps = results.map(_._2).sum + results.count { case (s, _) => s != maxSum }

      (maxSum + cost(node), totalOps)
    }

    dfs(0, -1)._2
  }
}
