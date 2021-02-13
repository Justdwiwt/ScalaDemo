package leetCode

import scala.collection.mutable

object Solution_502 {
  def findMaximizedCapital(k: Int, W: Int, Profits: Array[Int], Capital: Array[Int]): Int = {
    val arr = Profits.zip(Capital).sortWith(_._2 < _._2)
    val pq = mutable.PriorityQueue.empty[Int]
    var res = W
    var idx = 0
    var cnt = 0
    var flag = true
    while (flag && cnt < k) {
      while (idx < arr.length && arr(idx)._2 <= res) {
        pq += arr(idx)._1
        idx += 1
      }
      if (pq.nonEmpty) {
        res += pq.dequeue()
        cnt += 1
      } else flag = false
    }
    res
  }
}
