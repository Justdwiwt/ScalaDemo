package leetCode._400

import leetCode.ListNode

object Solution_369 {
  def plusOne(head: ListNode): ListNode = f(head) match {
    case 1 =>
      val h = new ListNode(1)
      h.next = head
      h
    case _ => head
  }

  def f(node: ListNode): Int = node match {
    case null => 1
    case _ =>
      val t = node.x
      node.x = (node.x + f(node.next)) % 10
      if (node.x < t) 1 else 0
  }
}
