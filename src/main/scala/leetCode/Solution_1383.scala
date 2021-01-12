package leetCode

import scala.collection.mutable

object Solution_1383 {
  val M = 1000000007L

  def maxPerformance(n: Int, speed: Array[Int], efficiency: Array[Int], k: Int): Int = {
    var sum = 0L
    val pq = mutable.PriorityQueue.empty(Ordering[Int].reverse)
    ((0 until n).sortWith((i, j) => efficiency(i) > efficiency(j))./:(0L)((res, i) => {
      sum += speed(i)
      pq += speed(i)
      if (pq.size > k) sum -= pq.dequeue()
      res.max(sum * efficiency(i).toLong)
    }) % M).toInt
  }
}
