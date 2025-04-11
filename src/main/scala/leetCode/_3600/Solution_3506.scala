package leetCode._3600

import scala.collection.mutable

object Solution_3506 {
  def minEliminationTime(timeReq: Array[Int], splitTime: Int): Long = {
    implicit val ord: Ordering[BigInt] = Ordering.BigInt.reverse
    val pq = mutable.PriorityQueue.empty[BigInt]
    timeReq.foreach(t => pq.enqueue(BigInt(t)))
    while (pq.size > 1) {
      val a = pq.dequeue()
      val b = pq.dequeue()
      val merged = BigInt(splitTime) + a.max(b)
      pq.enqueue(merged)
    }
    pq.dequeue().toLong
  }
}
