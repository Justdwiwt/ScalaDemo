package leetCode

object Offer_021 {
  def removeNthFromEnd(head: ListNode, n: Int): ListNode =
    if (head.next == null) null else f(head, n)._1

  def f(node: ListNode, n: Int): (ListNode, Int) = {
    val (_, y) = if (node.next != null) f(node.next, n) else (node, 1)
    if (n == y && node.next != null) {
      node.x = node.next.x
      node.next = node.next.next
    }
    if (n + 1 == y && y == 2 && node.next.next == null) node.next = null
    (node, y + 1)
  }
}
