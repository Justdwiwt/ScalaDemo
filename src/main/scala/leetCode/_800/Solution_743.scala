package leetCode._800

import scala.collection.mutable

object Solution_743 {
  def networkDelayTime(times: Array[Array[Int]], n: Int, k: Int): Int = {
    val visited = mutable.HashMap.empty[Int, Int].withDefaultValue(Int.MaxValue)
    val adj = mutable.HashMap.empty[Int, mutable.HashSet[(Int, Int)]]

    def bfs(i: Int): Unit = {
      val q = mutable.Queue.empty[(Int, Int)]
      q.enqueue((i, 0))
      visited.put(i, 0)
      while (q.nonEmpty) {
        val (x, cost) = q.dequeue()
        adj
          .getOrElse(x, mutable.HashSet.empty[(Int, Int)])
          .foreach { case (neighbor, c) =>
            if (!visited.contains(neighbor) || cost + c < visited(neighbor)) {
              visited.put(neighbor, cost + c)
              q.enqueue((neighbor, cost + c))
            }
          }
      }
    }

    times
      .withFilter { case Array(_, _, _) => true; case _ => false }
      .foreach { case Array(u, v, t) =>
        adj.get(u) match {
          case None => adj.put(u, mutable.HashSet((v, t)))
          case Some(s) => s.add((v, t))
        }
      }

    bfs(k)

    if (visited.size != n) -1
    else visited.values.max
  }
}
