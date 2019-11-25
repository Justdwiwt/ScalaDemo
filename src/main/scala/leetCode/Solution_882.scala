package leetCode

import scala.collection.mutable
import scala.util.control.Breaks._

object Solution_882 {
  def reachableNodes(edges: Array[Array[Int]], M: Int, N: Int): Int = {
    var res = 0
    val flag = Array.fill(N)(false)
    val q = new mutable.PriorityQueue[(Int, Int)]()
    val graph = Array.fill(N, N)(-1)
    q.enqueue((M, 0))
    edges.foreach(edge => {
      graph(edge(0))(edge(1)) = edge(2)
      graph(edge(1))(edge(0)) = edge(2)
    })
    while (q.nonEmpty) {
      val t = q.head
      q.dequeue
      val move = t._1
      val cur = t._2
      breakable {
        if (flag(cur)) break
      }
      flag(cur) = true
      res += 1
      (0 until N).foreach(i => {
        breakable {
          if (graph(cur)(i) == -1) break
        }
        if (move > graph(cur)(i) && !flag(i)) q.enqueue((move - graph(cur)(i) - 1, i))
        graph(i)(cur) -= move.min(graph(cur)(i))
        res += move.min(graph(cur)(i))
      })
    }
    res
  }
}
