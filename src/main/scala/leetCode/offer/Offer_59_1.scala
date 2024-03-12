package leetCode.offer

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Offer_59_1 {
  def maxSlidingWindow(nums: Array[Int], k: Int): Array[Int] = {
    val res = new ArrayBuffer[Int]()
    val pq = new mutable.PriorityQueue[(Int, Int)]()
    nums.indices.foreach(i => {
      while (pq.nonEmpty && pq.head._2 <= i - k) pq.dequeue
      pq.enqueue((nums(i), i))
      if (i >= k - 1) res.append(pq.head._1)
    })
    res.toArray
  }
}
