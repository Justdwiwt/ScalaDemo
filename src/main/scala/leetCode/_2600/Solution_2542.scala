package leetCode._2600

import scala.collection.mutable

object Solution_2542 {
  def maxScore(nums1: Array[Int], nums2: Array[Int], k: Int): Long = {
    val sorted = nums1.zip(nums2).sortBy(-_._2)
    val pq = mutable.PriorityQueue.empty[Long](Ordering.by(-_))
    sorted.take(k).map(_._1)./:(pq)((r, cur) => {
      r += cur.toLong
      r
    })
    sorted.drop(k)./:(pq, sorted.take(k).map(n => n._1.toLong).sum, sorted.take(k).map(n => n._1.toLong).sum * sorted.take(k).map(_._2).last)((r, cur) => {
      val t1 = r._2 - r._1.dequeue()
      r._1.enqueue(cur._1)
      (r._1, t1 + cur._1, r._3.max((t1 + cur._1) * cur._2))
    })._3
  }
}
