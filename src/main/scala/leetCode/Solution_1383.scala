package leetCode

import scala.collection.mutable

object Solution_1383 {
  def maxPerformance(n: Int, speed: Array[Int], efficiency: Array[Int], k: Int): Int = {
    val M = (1e9 + 7).toInt
    var arr = Array.ofDim[Int](n, 2)
    (0 until n).foreach(i => {
      arr(i)(0) = speed(i)
      arr(i)(1) = efficiency(i)
    })
    arr = arr.sortWith(_ (1) < _ (1))
    val pq = new mutable.PriorityQueue[Int]()
    var res = 0L
    var sum = 0
    (0 until n).foreach(i => {
      if (pq.length > k - 1) {
        sum -= pq.head
        pq.dequeue()
      }
      res = res.max((sum + arr(i)(0)) * arr(i)(1))
      pq.enqueue(arr(i)(0))
      sum += arr(i)(0)
    })
    (res % M).toInt
  }
}
