package leetCode.offer

import scala.collection.mutable

object Offer_078 {
  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  }

  def mergeKLists(lists: Array[ListNode]): ListNode = {
    val pq = mutable.PriorityQueue[ListNode](lists.filter(_ != null): _*)(Ordering.by(-_.x))
    val res = pq.headOption.orNull
    f(pq, null)
    res
  }

  @scala.annotation.tailrec
  def f(pq: mutable.PriorityQueue[ListNode], last: ListNode): Unit =
    if (pq.nonEmpty) {
      val h = pq.dequeue()
      if (last != null) last.next = h
      if (h.next != null) pq += h.next
      f(pq, h)
    }
}
