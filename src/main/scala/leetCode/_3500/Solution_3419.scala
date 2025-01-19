package leetCode._3500

import scala.collection.mutable

object Solution_3419 {
  def minMaxWeight(n: Int, edges: Array[Array[Int]], threshold: Int): Int = {
    if (edges.length < n - 1) return -1

    val g = Array.fill(n)(mutable.ListBuffer[(Int, Int)]())
    edges
      .withFilter { case Array(_, _, _) => true; case _ => false }
      .foreach { case Array(x, y, w) => g(y) += ((x, w)) }

    val INF = Int.MaxValue
    val dis = Array.fill(n)(INF)
    dis(0) = 0
    val pq = mutable.PriorityQueue((0, 0))(Ordering.by(-_._1))
    while (pq.nonEmpty) {
      val (d, x) = pq.dequeue()
      if (d > dis(x)) ()
      g(x).foreach { case (y, w) =>
        val newD = d.max(w)
        if (newD < dis(y)) {
          dis(y) = newD
          pq.enqueue((newD, y))
        }
      }
    }

    val res = dis.max
    if (res == INF) -1 else res
  }
}
