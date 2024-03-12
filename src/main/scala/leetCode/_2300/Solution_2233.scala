package leetCode._2300

import scala.collection.mutable

object Solution_2233 {
  def maximumProduct(nums: Array[Int], k: Int): Int = {
    val pq = mutable.PriorityQueue(nums: _*).reverse
    (0 until k).foreach(_ => pq += (pq.dequeue() + 1))
    pq.toArray.map(_.toLong).reduce(_ * _ % 1000000007).toInt
  }
}
