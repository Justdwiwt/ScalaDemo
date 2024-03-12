package leetCode._2000

import scala.collection.mutable

object Solution_1962 {
  def minStoneSum(piles: Array[Int], k: Int): Int = {
    val pq = mutable.PriorityQueue[Int](piles: _*)
    (1 to k).foreach(_ => {
      val t = pq.dequeue()
      pq += (t - t / 2)
    })
    pq.sum
  }
}
