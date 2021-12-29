package leetCode

import scala.collection.mutable

object Solution_2097 {
  def validArrangement(pairs: Array[Array[Int]]): Array[Array[Int]] = {
    val degree = mutable.HashMap.empty[Int, Int]
    val graph = mutable.HashMap.empty[Int, mutable.Queue[Int]]
    pairs.foreach(p => {
      degree += p.head -> (degree.getOrElse(p.head, 0) + 1)
      degree += p(1) -> (degree.getOrElse(p(1), 0) - 1)
      val edge: mutable.Queue[Int] = graph.getOrElse(p.head, mutable.Queue.empty[Int])
      edge += p(1)
      graph += p.head -> edge
    })
    var first = pairs.head.head
    degree.keySet.foreach(v => if (degree.getOrElse(v, 0) == 1) first = v)
    val route = mutable.ArrayBuffer.empty[Array[Int]]
    dfs(first, graph, route)
    val res = Array.fill(pairs.length, 2)(0)
    route.indices.foreach(i => res(i) = route(pairs.length - i - 1))
    res
  }

  def dfs(in: Int, graph: mutable.HashMap[Int, mutable.Queue[Int]], route: mutable.ArrayBuffer[Array[Int]]): Unit = {
    while (graph.keySet.contains(in) && graph(in).nonEmpty) {
      val out = graph(in).head
      graph(in) = graph(in).tail
      dfs(out, graph, route)
      route += Array(in, out)
    }
  }
}
