package leetCode.crackingCodeInterview

import leetCode.ListNode

object Code_02_04 {
  def partition(head: ListNode, x: Int): ListNode = {
    var node = head
    if (node == null || node.next == null) return node
    val p = partition(node.next, x)
    if (node.x < x) node.next = p
    else {
      var q = p
      while (q.next != null) q = q.next
      q.next = node
      node.next = null
      node = p
    }
    node
  }
}
