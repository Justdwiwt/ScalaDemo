package leetCode

import scala.collection.mutable

object Solution_2368 {
  def reachableNodes(n: Int, edges: Array[Array[Int]], restricted: Array[Int]): Int = {
    val st = restricted.toSet
    val visited = mutable.Set.empty[Int]
    val m = mutable.Map[Int, List[Int]]()
    edges.foreach(edge => {
      m += (edge.head -> (List(edge(1)) ::: m.getOrElse(edge.head, Nil)))
      m += (edge(1) -> (List(edge.head) ::: m.getOrElse(edge(1), Nil)))
    })

    def dfs(from: Int): Unit =
      if (!st.contains(from) && visited.add(from))
        m.getOrElse(from, Nil).foreach(dfs)

    dfs(0)
    visited.size
  }
}
