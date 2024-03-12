package leetCode._2100

import scala.collection.mutable

object Solution_2039 {
  def networkBecomesIdle(edges: Array[Array[Int]], patience: Array[Int]): Int = {
    val m = mutable.HashMap.empty[Int, mutable.ArrayBuffer[Int]]
    edges
      .withFilter({ case Array(_, _) => true; case _ => false })
      .foreach({ case Array(from, to) =>
        m.getOrElseUpdate(from, mutable.ArrayBuffer()).append(to)
        m.getOrElseUpdate(to, mutable.ArrayBuffer()).append(from)
      })

    val arr = Array.fill[Int](m.size)(-1)
    val pq = mutable.PriorityQueue[(Int, Int)]((0, 0))((x: (Int, Int), y: (Int, Int)) => y._2 - x._1)

    while (pq.nonEmpty) {
      val (node, d) = pq.dequeue()
      if (arr(node) == -1 || arr(node) > d) {
        arr(node) = d
        m(node).foreach(child => pq += ((child, d + 1)))
      }
    }

    val cc = arr.map(_ * 2).zipWithIndex.map({ case (fullDist, idx) =>
      if (idx == 0) 0
      else {
        val v = fullDist % patience(idx)
        if (v != 0) 2 * fullDist - v
        else 2 * fullDist - v - patience(idx)
      }
    })

    1 + cc.max
  }
}
