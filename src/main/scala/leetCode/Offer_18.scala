package leetCode

object Offer_18 {
  def deleteNode(head: ListNode, `val`: Int): ListNode = {
    var node = new ListNode(0)
    node.next = head
    val pre = node
    while (node != null && node.next != null) {
      if (node.next.x == `val`) node.next = node.next.next
      node = node.next
    }
    pre.next
  }
}
