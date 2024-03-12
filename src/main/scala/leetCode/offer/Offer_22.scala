package leetCode.offer

import leetCode.ListNode

object Offer_22 {
  def getKthFromEnd(head: ListNode, k: Int): ListNode = {
    var p = head
    var q = head
    var t = k
    while (p != null) {
      if (t > 0) {
        p = p.next
        t -= 1
      } else {
        p = p.next
        q = q.next
      }
    }
    q
  }
}
