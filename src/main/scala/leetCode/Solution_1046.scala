package leetCode

import scala.collection.mutable

object Solution_1046 {
  def lastStoneWeight(stones: Array[Int]): Int = {
    val pq = mutable.PriorityQueue[Int]() ++ stones
    while (pq.size > 1) pq += (pq.dequeue - pq.dequeue)
    if (pq.isEmpty) 0 else pq.dequeue
  }
}
