package leetCode._2800

import scala.collection.mutable

object Solution_2714 {
  private val INF = Int.MaxValue >> 1

  def shortestPathWithHops(n: Int, edges: Array[Array[Int]], s: Int, d: Int, k: Int): Int = {
    val graph = Array.fill(n)(mutable.ListBuffer.empty[Array[Int]])
    edges.foreach(e => {
      graph(e.head).append(Array(e(1), e(2)))
      graph(e(1)).append(Array(e.head, e(2)))
    })
    val distance = Array.fill(n, k + 1)(INF)
    distance(s)(0) = 0
    val pq = mutable.PriorityQueue.empty[Array[Int]](Ordering.by((_: Array[Int]).head).reverse)
    pq.enqueue(Array(0, s, 0))
    var res = INF
    while (pq.nonEmpty) {
      val p = pq.dequeue()
      val d1 = p.head
      val x = p(1)
      val t = p(2)
      if (d1 > distance(x)(t)) ()
      else {
        graph(x).foreach(next => {
          val y = next.head
          val w = next(1)
          val newDistance = d1 + w
          if (newDistance < distance(y)(t)) {
            distance(y)(t) = newDistance
            pq.enqueue(Array(newDistance, y, t))
            if (y == d) res = res.min(newDistance)
          }
          if (t < k)
            if (d1 < distance(y)(t + 1)) {
              distance(y)(t + 1) = d1
              pq.enqueue(Array(d1, y, t + 1))
              if (y == d) res = res.min(d1)
            }
        })
      }
    }
    if (res < INF) res else -1
  }
}
