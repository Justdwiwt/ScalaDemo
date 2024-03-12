package leetCode._2000

import scala.collection.mutable

object Solution_1976 {
  def countPaths(n: Int, roads: Array[Array[Int]]): Int = {
    val m = mutable.HashMap.empty[Int, List[(Int, Int)]]
    roads.foreach(a => {
      m(a.head) = (a(1), a(2)) :: m.getOrElse(a.head, Nil)
      m(a(1)) = (a(0), a(2)) :: m.getOrElse(a(1), Nil)
    })

    val ways = Array.fill[Int](n)(0)
    val dist = Array.fill[Long](n)(Long.MaxValue)

    ways(0) = 1
    dist(0) = 0L

    val pq = mutable.PriorityQueue((0L, 0)).reverse

    while (pq.nonEmpty && pq.head._1 <= dist(n - 1)) {
      val (ud, u) = pq.dequeue
      if (dist(u) >= ud) m.getOrElse(u, Nil)
        .map({ case (v, d) => val vd = dist(u) + d; ((v, d), vd) })
        .withFilter({ case ((v, _), vd) => dist(v) >= vd })
        .foreach({ case ((v, _), vd) =>
          if (dist(v) > vd) {
            dist(v) = vd
            ways(v) = ways(u)
            pq += ((vd, v))
          } else ways(v) = ((ways(v).toLong + ways(u)) % (1e9.toInt + 7)).toInt
        })
    }
    ways(n - 1)
  }
}
