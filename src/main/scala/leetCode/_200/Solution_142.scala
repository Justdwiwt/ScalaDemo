package leetCode._200

import leetCode.ListNode

object Solution_142 {
  def detectCycle(head: ListNode): ListNode = {
    @scala.annotation.tailrec
    def f(slow: ListNode, fast: ListNode): ListNode = {
      if (slow == fast) g(head, slow)
      else if (fast == null || fast.next == null) null
      else f(slow.next, fast.next.next)
    }

    @scala.annotation.tailrec
    def g(cur: ListNode, slow: ListNode): ListNode = {
      if (cur == slow) slow
      else g(cur.next, slow.next)
    }

    if (head == null || head.next == null) null
    else f(head.next, head.next.next)
  }
}
