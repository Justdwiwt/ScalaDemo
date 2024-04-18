package leetCode._2700

import leetCode.Common.ListNode

object Solution_2674 {
  def splitCircularLinkedList(list: ListNode): Array[ListNode] = {
    var p1 = list
    var p2 = list
    var lst = list
    var f = 1

    while (p2.next != list) {
      lst = p1
      p1 = p1.next
      if (p2.next.next != list) {
        p2 = p2.next.next
        f += 2
      } else {
        p2 = p2.next
        f += 1
      }
    }

    val mid = if ((f & 1) == 1) p1 else lst
    val q = mid.next
    mid.next = list
    p2.next = q
    Array(list, q)
  }
}
