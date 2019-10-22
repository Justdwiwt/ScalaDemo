package leetCode

import java.util

object Solution_785 {
  var isVisited: Array[Int] = _
  var graph: Array[Array[Int]] = _
  var res = true

  def isBipartite(graph: Array[Array[Int]]): Boolean = {
    isVisited = new Array[Int](graph.length)
    util.Arrays.fill(isVisited, -1)
    this.graph = graph
    graph.indices.foreach(i => if (isVisited(i) == -1) dfs(i, 0))
    res
  }

  def dfs(i: Int, needed: Int): Unit = {
    if (isVisited(i) == -1) isVisited(i) = needed
    else if (isVisited(i) == needed) return
    else {
      res = false
      return
    }
    graph(i).indices.foreach(j => {
      if (needed == 1) dfs(graph(i)(j), 0)
      else dfs(graph(i)(j), 1)
    })
  }
}
