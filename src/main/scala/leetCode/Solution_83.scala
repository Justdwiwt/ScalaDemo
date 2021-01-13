package leetCode

object Solution_83 {
  def deleteDuplicates(head: ListNode): ListNode = {
    def f(node: ListNode, acc: ListNode, v: List[Int]): ListNode =
      if (node.next == null) node
      else if (v.contains(node.next.x)) f(node.next, acc, v)
      else {
        acc.next = f(node.next, node.next, node.next.x +: v)
        acc
      }

    if (head != null) f(head, new ListNode(head.x), List(head.x))
    else head
  }
}
