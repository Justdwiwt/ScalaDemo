package leetCode._200

import leetCode.ListNode

object Solution_160 {
  def getIntersectionNode(headA: ListNode, headB: ListNode): ListNode = {
    @scala.annotation.tailrec
    def f(pA: ListNode, pB: ListNode): ListNode =
      if (pA != pB) {
        val newA = if (pA == null) headB else pA.next
        val newB = if (pB == null) headA else pB.next
        f(newA, newB)
      } else pA

    f(headA, headB)
  }
}
