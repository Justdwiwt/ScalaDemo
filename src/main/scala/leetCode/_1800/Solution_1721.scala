package leetCode._1800

object Solution_1721 {

  class ListNode(_x: Int = 0, _next: ListNode = null) {
    val next: ListNode = _next
    var x: Int = _x
  }

  def swapNodes(head: ListNode, k: Int): ListNode = {
    @scala.annotation.tailrec
    def f(node: ListNode, n: Int): ListNode =
      if (n == k) node else f(node.next, n + 1)

    @scala.annotation.tailrec
    def g(node1: ListNode, node2: ListNode): ListNode =
      if (node2.next == null) node1 else g(node1.next, node2.next)

    val node1 = f(head, 1)
    val node2 = g(head, node1)

    val tmp = node1.x
    node1.x = node2.x
    node2.x = tmp

    head
  }
}
