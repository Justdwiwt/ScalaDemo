package leetCode.LCP

import java.util.PriorityQueue
import scala.collection.mutable
import scala.util.control.Breaks._

object LCP_35 {
  def electricCarPlan(paths: Array[Array[Int]], cnt: Int, start: Int, end: Int, charge: Array[Int]): Int = {
    if (start == end) return 0
    val n = charge.length
    val dist = Array.fill(n, cnt + 1)(1e9.toInt)
    val g = Array.fill(n)(mutable.HashMap.empty[Int, Int])
    paths.foreach(p => {
      val s = p.head
      val e = p(1)
      val d = p(2)
      g(s).getOrElse(e, d)
      g(s) += e -> d.min(g(s)(e))
      g(e).getOrElse(s, d)
      g(e) += s -> d.min(g(e)(s))
    })

    dist(start)(0) = 0

    val pq = new PriorityQueue[Array[Int]]((a: Array[Int], b: Array[Int]) => a.head - b.head)

    pq.offer(Array(0, start, 0))

    while (!pq.isEmpty) {
      val c = pq.poll()
      val d = c.head
      val loc = c(1)
      if (loc == end) return d
      val ch = c(2)
      breakable(if (d > dist(loc)(ch)) break())
      if (ch < cnt) {
        val newCh = ch + 1
        val newDist = d + charge(loc)
        if (newDist < dist(loc)(newCh)) {
          dist(loc)(newCh) = newDist
          pq.offer(Array(newDist, loc, newCh))
        }
        g(loc).keySet.foreach(next => {
          val dln = g(loc)(next)
          if (ch >= dln) {
            val newCh = ch - dln
            val newDist = d + dln
            if (newDist < dist(next)(newCh)) {
              dist(next)(newCh) = newDist
              pq.offer(Array(newDist, next, newCh))
            }
          }
        })
      }
    }
    -1
  }
}
