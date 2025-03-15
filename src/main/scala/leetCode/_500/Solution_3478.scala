package leetCode._500

import scala.collection.mutable

object Solution_3478 {
  def findMaxSum(nums1: Array[Int], nums2: Array[Int], k: Int): Array[Long] = {
    val n = nums1.length
    val arr = Array.ofDim[Int](n, 3)

    nums1.indices.foreach(i => arr(i) = Array(nums1(i), nums2(i), i))

    val sorted = arr.sortBy(_.head)

    val res = Array.fill(n)(0L)
    val pq = mutable.PriorityQueue[Int]()(Ordering[Int].reverse)
    var s = 0L

    nums1.indices.foreach(i => {
      res(sorted(i)(2)) = if (i > 0 && sorted(i).head == sorted(i - 1).head) res(sorted(i - 1)(2)) else s
      val y = sorted(i)(1)
      s += y
      pq += y
      if (pq.size > k) s -= pq.dequeue()
    })

    res
  }
}
