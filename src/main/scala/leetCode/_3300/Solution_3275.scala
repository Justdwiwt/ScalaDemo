package leetCode._3300

import scala.collection.mutable

object Solution_3275 {
  def resultsArray(queries: Array[Array[Int]], k: Int): Array[Int] = {
    val res = Array.fill(queries.length)(-1)
    val pq = mutable.PriorityQueue.empty[Int](Ordering[Int].reverse)
    queries.indices.foreach(i => {
      val x = queries(i).head
      val y = queries(i)(1)
      pq += (-(x.abs + y.abs))
      if (pq.size > k) pq.dequeue()
      if (pq.size == k) res(i) = -pq.head
    })
    res
  }
}
