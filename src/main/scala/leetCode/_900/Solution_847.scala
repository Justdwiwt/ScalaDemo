package leetCode._900

import scala.collection.mutable

object Solution_847 {
  def shortestPathLength(graph: Array[Array[Int]]): Int = {
    val mask = (1 << graph.length) - 1
    val m = mutable.HashMap.empty[(Int, Int), Int]

    def f(node: Int, mask: Int): Int = {
      if (m.contains((node, mask))) return m((node, mask))
      if ((mask & (mask - 1)) == 0) return 0
      m((node, mask)) = Integer.MAX_VALUE - 1
      graph(node).foreach(nei => if ((mask & (1 << nei)) != 0) {
        val alreadyVisited = 1 + f(nei, mask)
        val notVisited = 1 + f(nei, mask ^ (1 << node))
        m((node, mask)) = m((node, mask)).min(alreadyVisited).min(notVisited)
      })
      m(node, mask)
    }

    graph.indices.map(f(_, mask)).min
  }
}
