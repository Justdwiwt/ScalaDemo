package leetCode._3100

import scala.collection.mutable

object Solution_3092 {
  def mostFrequentIDs(a: Array[Int], b: Array[Int]): Array[Long] = {
    val pq = mutable.PriorityQueue[Array[Long]]()(Ordering.by(_(1)))
    val n = a.length
    val f = Array.fill(a.max + 1)(0L)
    val res = Array.fill(n)(0L)
    a.indices.foreach(i => {
      val x = a(i)
      val occ = b(i).toLong
      f(x) += occ
      pq += Array(x.toLong, f(x))
      while (pq.nonEmpty && pq.head(1) != f(pq.head.head.toInt)) pq.dequeue
      res(i) = if (pq.isEmpty) 0 else pq.head(1)
    })
    res
  }
}
