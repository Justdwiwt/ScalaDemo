package leetCode

import scala.collection.mutable

object Solution_1439 {
  def kthSmallest(mat: Array[Array[Int]], k: Int): Int = {
    var pq = mutable.PriorityQueue.empty[Int].reverse
    pq += 0
    mat.foreach(m => {
      val t = pq.toArray
      pq = mutable.PriorityQueue.empty[Int]
      t.foreach(i => m.foreach(n => pq += (i + n)))
      while (pq.size > k) pq.dequeue
    })
    pq.head
  }
}
