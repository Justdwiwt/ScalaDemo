package leetCode._2500

import scala.collection.mutable

object Solution_2473 {
  private case class State(id: Int, distFromStart: Long)

  private def makeGraph(n: Int, roads: Array[Array[Int]], appleCost: Array[Int]): Array[Array[(Int, Int)]] = {
    val graph = Array.fill(n + 1)(mutable.ArrayBuffer.empty[(Int, Int)])

    roads.collect { case Array(from, to, cost) =>
      graph(from).append((to, cost))
      graph(to).append((from, cost))
    }

    appleCost.indices.foreach(i => graph.head.append((i + 1, appleCost(i))))

    graph.map(_.toArray)
  }

  private def dijkstra(start: Int, graph: Array[Array[(Int, Int)]], k: Int): Array[Long] = {
    val stack = mutable.Stack[State]()
    val dist = Array.fill(graph.length)(Long.MaxValue)
    dist(start) = 0L
    stack.push(State(start, 0L))

    def f(): Unit = {
      if (stack.nonEmpty) {
        val node = stack.pop()
        val curId = node.id
        val curDistFromStart = node.distFromStart

        if (curDistFromStart > dist(curId)) f()
        else graph(curId).foreach { case (to, cost) =>
          val nextDistFromStart = if (curId == 0) cost.toLong else cost.toLong * (1 + k) + curDistFromStart
          if (dist(to) > nextDistFromStart) {
            dist(to) = nextDistFromStart
            stack.push(State(to, nextDistFromStart))
          }
        }
        f()
      }
    }

    f()
    dist
  }

  def minCost(n: Int, roads: Array[Array[Int]], appleCost: Array[Int], k: Int): Array[Long] = {
    val graph = makeGraph(n, roads, appleCost)
    dijkstra(0, graph, k).tail
  }
}
