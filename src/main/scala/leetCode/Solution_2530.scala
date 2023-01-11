package leetCode

import scala.collection.mutable

object Solution_2530 {
  def maxKelements(nums: Array[Int], k: Int): Long = {
    val pq = mutable.PriorityQueue[Int]() ++ nums
    (1 to k)./:(0L, pq) { case ((cnt, p), _) =>
      val m = p.dequeue.toLong
      p.enqueue(math.ceil(m.toDouble / 3).toInt)
      (cnt + m, p)
    }._1
  }
}
