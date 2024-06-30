package leetCode._1800

import scala.collection.mutable

object Solution_1786 {
  val M = 1000000007

  def countRestrictedPaths(n: Int, es: Array[Array[Int]]): Int = {
    val map = es.foldLeft(Map.empty[Int, Map[Int, Int]]) {
      case (acc, Array(a, b, w)) =>
        val am = acc.getOrElse(a, Map.empty[Int, Int]) + (b -> w)
        val bm = acc.getOrElse(b, Map.empty[Int, Int]) + (a -> w)
        acc + (a -> am) + (b -> bm)
    }

    val dist = Array.fill(n + 1)(Int.MaxValue)
    dist(n) = 0
    val pq = mutable.PriorityQueue((n, 0))(Ordering.by(-_._2))

    while (pq.nonEmpty) {
      val (idx, _) = pq.dequeue()
      map.get(idx).foreach(_.foreach {
        case (i, w) => if (dist(i) > dist(idx) + w) {
          dist(i) = dist(idx) + w
          pq += ((i, dist(i)))
        }
      })
    }

    val sorted = (1 to n).map(i => (i, dist(i))).sortBy(_._2)

    val arr = Array.fill(n + 1)(0)
    arr(n) = 1

    sorted.foreach { case (idx, cur) =>
      map.get(idx).foreach(_.foreach { case (next, _) =>
        if (cur > dist(next)) arr(idx) = (arr(idx) + arr(next)) % M
      })
    }

    arr(1)
  }
}
