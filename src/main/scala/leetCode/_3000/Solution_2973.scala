package leetCode._3000

object Solution_2973 {
  def placedCoins(edges: Array[Array[Int]], cost: Array[Int]): Array[Long] = {
    val graph: Map[Int, List[Int]] = edges.foldLeft(Map.empty[Int, List[Int]])((g, edge) => {
      val Array(from, to) = edge
      g.updated(from, g.getOrElse(from, Nil) :+ to).updated(to, g.getOrElse(to, Nil) :+ from)
    })

    def dfs(node: Int, parent: Int, cur: Array[Long]): (List[Int], Array[Long]) = {
      val neighbors = graph.getOrElse(node, Nil).filter(_ != parent)

      val (allNodes, updatedRet) = neighbors.foldLeft((List(cost(node)), cur)) { case ((accNodes, accRet), neighbor) =>
        val (childNodes, childRet) = dfs(neighbor, node, accRet)
        (accNodes ++ childNodes, childRet)
      }

      val sortedNodes = allNodes.sorted
      val n = sortedNodes.size
      val newRet = if (n >= 3) {
        val prod1 = 1L * sortedNodes(n - 1) * sortedNodes(n - 2) * sortedNodes(n - 3)
        val prod2 = 1L * sortedNodes.head * sortedNodes(1) * sortedNodes(n - 1)
        updatedRet.updated(node, 0L.max(prod1.max(prod2)))
      } else updatedRet

      (if (sortedNodes.size > 5) sortedNodes.take(2) ++ sortedNodes.drop(sortedNodes.size - 3) else sortedNodes, newRet)
    }

    dfs(0, -1, Array.fill(cost.length)(1L))._2
  }
}
