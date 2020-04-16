package leetCode

object Solution_160 {
  def getIntersectionNode(headA: ListNode, headB: ListNode): ListNode = {
    if (headA == null || headB == null) return null
    if (headA == headB) return headA
    var pA = headA
    var pB = headB
    var cnt = 0
    while (pA != pB && cnt < 3) {
      if (pA.next == null) {
        pA = headB
        cnt += 1
      } else pA = pA.next
      if (pB.next == null) {
        pB = headA
        cnt += 1
      } else pB = pB.next
    }
    if (pA == pB) pA else null
  }
}
