package leetCode._3700

import scala.collection.mutable

object Solution_3650 {
  def minCost(n: Int, edges: Array[Array[Int]]): Int = {
    val g = Array.fill(n)(List.empty[(Int, Int)])
    edges.foreach(e => {
      val x = e(0)
      val y = e(1)
      val w = e(2)
      g(x) = (y, w) :: g(x)
      g(y) = (x, w * 2) :: g(y)
    })

    val INF = Long.MaxValue / 4
    val dist = Array.fill[Long](n)(INF)
    dist(0) = 0

    val pq = mutable.PriorityQueue.empty[(Long, Int)](Ordering.by[(Long, Int), Long](-_._1))
    pq.enqueue((0L, 0))

    @scala.annotation.tailrec
    def dijkstra(): Long =
      if (pq.isEmpty) -1
      else {
        val (d, x) = pq.dequeue()
        if (d > dist(x)) dijkstra()
        else if (x == n - 1) d
        else {
          g(x).foreach { case (y, w) =>
            val nd = d + w
            if (nd < dist(y)) {
              dist(y) = nd
              pq.enqueue((nd, y))
            }
          }
          dijkstra()
        }
      }

    val ans = dijkstra()
    if (ans < 0) -1 else ans.toInt
  }
}
