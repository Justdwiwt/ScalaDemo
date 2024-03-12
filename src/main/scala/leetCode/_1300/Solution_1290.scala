package leetCode._1300

import leetCode.ListNode

object Solution_1290 {
  def getDecimalValue(head: ListNode): Int = {
    @scala.annotation.tailrec
    def f(node: ListNode, res: Int): Int = node match {
      case null => res
      case _ => f(node.next, (res << 1) + node.x)
    }

    f(head, 0)
  }
}
