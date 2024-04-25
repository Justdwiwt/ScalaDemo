package leetCode._2100

import leetCode.Common.ListNode

object Solution_2046 {
  def sortLinkedList(head: ListNode): ListNode = {
    var h = head
    if (h == null || h.next == null) return h
    var pre = h
    var cur = h.next
    while (cur != null) {
      if (cur.x >= 0) {
        pre = pre.next
        cur = pre.next
      }
      if (cur != null && cur.x < 0) {
        pre.next = cur.next
        cur.next = h
        h = cur
        cur = pre.next
      }
    }
    h
  }
}
