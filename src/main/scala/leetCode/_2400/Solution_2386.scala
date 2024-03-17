package leetCode._2400

import scala.collection.mutable

object Solution_2386 {
  def kSum(nums: Array[Int], k: Int): Long = {
    val maxSum = nums.map(_.toLong).filter(_ > 0).sum
    if (k == 1) return maxSum

    val sorted = nums.map(_.abs).sorted
    val pq = mutable.PriorityQueue((maxSum - sorted.head, 0))

    (0 until k - 2).foreach(_ => {
      val (nextSum, i) = pq.dequeue()
      if (sorted.isDefinedAt(i + 1)) {
        pq += ((nextSum + sorted(i) - sorted(i + 1), i + 1))
        pq += ((nextSum - sorted(i + 1), i + 1))
      }
    })

    pq.dequeue()._1
  }
}
