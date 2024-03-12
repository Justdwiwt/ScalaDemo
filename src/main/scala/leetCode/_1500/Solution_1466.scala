package leetCode._1500

import scala.collection.mutable

object Solution_1466 {
  def minReorder(n: Int, connections: Array[Array[Int]]): Int = {
    val graph = mutable.HashMap[Int, Set[(Int, Boolean)]]().withDefaultValue(Set.empty)
    connections.foreach(edge => {
      graph(edge.head) += (edge.last -> true)
      graph(edge.last) += (edge.head -> false)
    })

    var cnt = 0
    val vis = mutable.HashMap[Int, Unit]()

    def dfs(node: Int): Unit = {
      vis += node -> ()
      graph(node).foreach({ case (child, existingEdge) =>
        if (!vis.contains(child)) {
          if (existingEdge) cnt += 1
          dfs(child)
        }
      })
    }

    dfs(0)
    cnt
  }
}
