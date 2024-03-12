package leetCode._300

import leetCode.ListNode

object Solution_206 {
  def reverseList(head: ListNode): ListNode = {
    @scala.annotation.tailrec
    def f(pre: ListNode, cur: ListNode, next: ListNode): ListNode = {
      cur.next = pre
      if (next != null) f(cur, next, next.next) else cur
    }

    if (head == null) null else f(null, head, head.next)
  }
}
