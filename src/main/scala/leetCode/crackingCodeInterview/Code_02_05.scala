package leetCode.crackingCodeInterview

import leetCode.ListNode

object Code_02_05 {
  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    val res = new ListNode(-1)
    var cur = res
    var c = 0
    var sum = 0
    var n1 = l1
    var n2 = l2
    while (n1 != null || n2 != null || c != 0) {
      val v1 = if (n1 == null) 0 else n1.x
      val v2 = if (n2 == null) 0 else n2.x
      sum = v1 + v2 + c
      c = sum / 10
      cur.next = new ListNode(sum % 10)
      n1 = if (n1 == null) null else n1.next
      n2 = if (n2 == null) null else n2.next
      cur = cur.next
    }
    res.next
  }
}
