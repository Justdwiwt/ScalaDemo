package leetCode._3300

object Solution_3249 {
  def countGoodNodes(edges: Array[Array[Int]]): Int = {
    val graph = edges
      .flatMap(edge => Array((edge.head, edge(1)), (edge(1), edge.head)))
      .groupBy(_._1)
      .mapValues(_.map(_._2))

    val mx = edges.foldLeft(0)((mx, edge) => mx.max(edge.max))

    val nodeSize = Array.fill(mx + 1)(0)
    val visited = Array.fill(mx + 1)(false)
    val topoVisited = Array.fill(mx + 1)(false)

    @scala.annotation.tailrec
    def f(toVisit: List[Int], visited: List[Int]): List[Int] = toVisit match {
      case Nil => visited
      case node :: rest =>
        topoVisited(node) = true
        val filtered = graph(node).filterNot(topoVisited(_))
        f(filtered ++: rest, node :: visited)
    }

    def isGood(node: Int): Boolean = {
      visited(node) = true
      val children = graph(node).filter(visited(_))
      if (children.isEmpty) {
        nodeSize(node) = 1
        return true
      }
      val childrenSize = children.map(nodeSize(_))
      nodeSize(node) = 1 + childrenSize.sum
      childrenSize.forall(_ == childrenSize.head)
    }

    f(List(0), Nil).count(isGood)
  }
}
