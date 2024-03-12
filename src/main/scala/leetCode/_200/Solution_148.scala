package leetCode._200

import leetCode.ListNode

object Solution_148 {
  def sortList(head: ListNode): ListNode = {
    @scala.annotation.tailrec
    def tolist(node: ListNode, acc: List[Int] = List()): List[Int] = if (node == null) acc else tolist(node.next, node.x :: acc)

    val newHead = new ListNode()
    tolist(head).sorted./:(newHead) { case (tail: ListNode, x: Int) =>
      tail.next = new ListNode(x)
      tail.next
    }
    newHead.next
  }
}
