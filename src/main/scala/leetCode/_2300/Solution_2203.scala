package leetCode._2300

import scala.collection.mutable

object Solution_2203 {
  private final val INF = -1L

  def minimumWeight(n: Int, edges: Array[Array[Int]], src1: Int, src2: Int, dest: Int): Long = {
    val adj1 = create(n, edges, reverse = false)
    val adj2 = create(n, edges, reverse = true)
    val dist1 = dijkstra(src1, n, adj1)
    val dist2 = dijkstra(src2, n, adj1)
    val dist3 = dijkstra(dest, n, adj2)
    var res = Long.MaxValue
    (0 until n).foreach(i => if (dist1(i) != INF && dist2(i) != INF && dist3(i) != INF) {
      res = res.min(dist1(i) + dist2(i) + dist3(i))
    })
    if (res == Long.MaxValue) -1 else res
  }

  private def create(n: Int, edges: Array[Array[Int]], reverse: Boolean): Array[List[(Int, Int)]] = {
    val adj = Array.fill(n)(List.empty[(Int, Int)])
    edges.foreach(edge => {
      val (x, y, w) = (edge.head, edge(1), edge(2))
      if (!reverse) adj(x) = (y, w) :: adj(x)
      else adj(y) = (x, w) :: adj(y)
    })
    adj
  }

  private def dijkstra(start: Int, n: Int, adj: Array[List[(Int, Int)]]): Array[Long] = {
    val dist = Array.fill(n)(INF)
    dist(start) = 0
    val vis = Array.fill(n)(false)
    val heap = mutable.PriorityQueue.empty[(Int, Long)](Ordering.by[(Int, Long), Long](_._2).reverse)
    heap.enqueue((start, 0))
    while (heap.nonEmpty) {
      val (curNode, curDist) = heap.dequeue()
      if (!vis(curNode)) {
        vis(curNode) = true
        adj(curNode).foreach { case (nextNode, weight) =>
          if (dist(nextNode) == INF || dist(nextNode) > curDist + weight) {
            dist(nextNode) = curDist + weight
            heap.enqueue((nextNode, dist(nextNode)))
          }
        }
      }
    }
    dist
  }
}
