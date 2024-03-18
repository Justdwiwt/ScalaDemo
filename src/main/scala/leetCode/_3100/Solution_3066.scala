package leetCode._3100

import scala.collection.mutable

object Solution_3066 {
  def minOperations(nums: Array[Int], k: Int): Int = {
    val pq = mutable.PriorityQueue(nums.map(_.toLong): _*)(Ordering[Long].reverse)
    while (pq.head < k) pq += 2 * pq.dequeue() + pq.dequeue()
    nums.length - pq.length
  }
}
