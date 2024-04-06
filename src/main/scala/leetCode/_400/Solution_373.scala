package leetCode._400

import scala.collection.mutable

object Solution_373 {
  def kSmallestPairs(nums1: Array[Int], nums2: Array[Int], k: Int): List[List[Int]] = {
    val init = nums1.indices.map(i => node(nums1(i), nums2.head, i, 0))
    val pq = mutable.PriorityQueue[node](init: _*)(Ordering.by(node => -node.a - node.b))

    @scala.annotation.tailrec
    def f(k: Int, pq: mutable.PriorityQueue[node], ans: List[List[Int]]): List[List[Int]] = {
      if (k <= 0 || pq.isEmpty) ans
      else {
        val top = pq.dequeue()
        val newAns = ans :+ top.toList()
        if (top.d + 1 < nums2.length) pq.enqueue(node(nums1(top.c), nums2(top.d + 1), top.c, top.d + 1))
        f(k - 1, pq, newAns)
      }
    }

    f(k, pq, List.empty[List[Int]])
  }

  private case class node(a: Int, b: Int, c: Int, d: Int) {
    def toList(): List[Int] = List(a, b)
  }
}
