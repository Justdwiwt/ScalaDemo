package leetCode

import java.util

object Solution_847 {
  def shortestPathLength(graph: Array[Array[Int]]): Int = {
    val INF = 0x3f3f3f3f
    val n = graph.length
    val mask = 1 << n
    val dist = Array.ofDim[Int](mask, n)
    (0 until mask).foreach(i => dist(i) = Array.fill(i)(INF))
    val d = new util.ArrayDeque[Array[Int]]()
    graph.indices.foreach(i => {
      dist(1 << i)(i) = 0
      d.addLast(Array(1 << i, i))
    })
    while (!d.isEmpty) {
      val poll = d.pollFirst()
      val state = poll.head
      val u = poll(1)
      val step = dist(state)(u)
      if (state == mask - 1) return step
      graph(u).foreach(i => if (dist(state | (1 << i))(i) == INF) {
        dist(state | (1 << i))(i) = step + 1
        d.addLast(Array(state | (1 << i), i))
      })
    }
    -1
  }
}
