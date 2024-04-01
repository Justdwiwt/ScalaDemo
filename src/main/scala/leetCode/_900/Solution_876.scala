package leetCode._900

import leetCode.ListNode

object Solution_876 {
  def middleNode(head: ListNode): ListNode = {
    @scala.annotation.tailrec
    def f(slow: ListNode, fast: ListNode): ListNode =
      if (fast != null && fast.next != null) f(slow.next, fast.next.next)
      else slow

    f(head, head)
  }
}
