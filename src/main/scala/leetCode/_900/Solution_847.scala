package leetCode._900

import scala.collection.mutable

object Solution_847 {
  def shortestPathLength(graph: Array[Array[Int]]): Int = {
    val q = mutable.Queue.empty[(Int, Int)]
    val st = mutable.HashSet.empty[(Int, Int)]
    val fullMask = (1 << graph.length) - 1
    graph.indices.foreach(i => q += ((i, 1 << i)))
    var step = 0
    while (q.nonEmpty) {
      val size = q.size
      (0 until size).foreach(_ => {
        val (ending, mask) = q.dequeue()
        if (mask == fullMask) return step
        val next = graph(ending)
        next.foreach(n => {
          val nextMask = mask | (1 << n)
          if (!st.contains((n, nextMask))) {
            q += ((n, nextMask))
            st += ((n, nextMask))
          }
        })
      })
      step += 1
    }
    -1
  }
}
