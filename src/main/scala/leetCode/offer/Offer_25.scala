package leetCode.offer

import leetCode.ListNode

object Offer_25 {
  def mergeTwoLists(l1: ListNode, l2: ListNode): ListNode = {
    var l = new ListNode()
    var t = new ListNode()
    var res = new ListNode()
    var L1 = l1
    var L2 = l2
    if (L1 == null) return L2
    if (L2 == null) return L1
    if (L1.x > L2.x) {
      l = L2
      L2 = L1
      L1 = l
    }
    res = L1
    while (L2 != null) {
      if (L1 == null) return res
      if (L1.next == null || L2.x < L1.next.x) {
        l = L1.next
        t = L2.next
        L1.next = L2
        L2.next = l
        L1 = L2
        L2 = t
      } else L1 = L1.next
    }
    res
  }
}
