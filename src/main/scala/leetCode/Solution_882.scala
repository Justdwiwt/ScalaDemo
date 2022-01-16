package leetCode

import scala.collection.mutable

object Solution_882 {
  case class Node(node: Int, dist: Int)

  def reachableNodes(edges: Array[Array[Int]], maxMoves: Int, n: Int): Int = {
    val graph = mutable.HashMap.empty[Int, mutable.HashMap[Int, Int]]
    edges
      .withFilter({ case Array(_, _, _) => true; case _ => false })
      .foreach({ case Array(u, v, w) =>
        graph.getOrElseUpdate(u, mutable.HashMap[Int, Int]()) += v -> w
        graph.getOrElseUpdate(v, mutable.HashMap[Int, Int]()) += u -> w
      })
    val pq = mutable.PriorityQueue.empty[Node](Ordering.by(_.dist)).reverse
    pq += Node(0, 0)
    val distMap = mutable.HashMap[Int, Int](0 -> 0)
    val used = mutable.HashMap.empty[Int, Int]
    var res = 0
    while (pq.nonEmpty) {
      val Node(node, dist) = pq.dequeue()
      if (dist <= distMap.getOrElse(node, 0)) {
        res += 1
        if (graph.contains(node)) {
          graph(node).keySet.foreach(nei => {
            val weight = graph(node)(nei)
            val v = weight.min(maxMoves - dist)
            used += n * node + nei -> v
            val d2 = dist + weight + 1
            if (d2 < distMap.getOrElse(nei, maxMoves + 1)) {
              pq += Node(nei, d2)
              distMap += nei -> d2
            }
          })
        }
      }
    }
    edges.foreach(x => res += x(2).min(used.getOrElse(x.head * n + x(1), 0) + used.getOrElse(x(1) * n + x.head, 0)))
    res
  }
}
