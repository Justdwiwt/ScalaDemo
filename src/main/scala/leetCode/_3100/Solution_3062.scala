package leetCode._3100

import leetCode.ListNode

object Solution_3062 {
  def gameResult(head: ListNode): String = {
    @scala.annotation.tailrec
    def f(node: ListNode, c1: Int, c2: Int): (Int, Int) = {
      if (node == null || node.next == null) (c1, c2)
      else {
        val (newC1, newC2) =
          if (node.x > node.next.x) (c1 + 1, c2)
          else if (node.x < node.next.x) (c1, c2 + 1)
          else (c1, c2)
        f(node.next.next, newC1, newC2)
      }
    }

    val (c1, c2) = f(head, 0, 0)

    if (c1 == c2) "Tie"
    else if (c1 > c2) "Even"
    else "Odd"
  }
}
