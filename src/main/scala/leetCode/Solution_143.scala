package leetCode

object Solution_143 {
  object ListNode {
    def unapply(node: ListNode): Option[Int] = Some(node.x)
  }

  def reorderList(head: ListNode): Unit = {
    def cut(cur: ListNode, cnt: Int = 0): (ListNode, Int) = cur match {
      case ListNode(_) =>
        val res = cut(cur.next, cnt + 1)
        if (cnt == res._2 / 2 + (res._2 % 2) - 1) {
          val temp = cur.next
          cur.next = null
          Tuple2(temp, res._2)
        }
        else res
      case null => Tuple2(null, cnt)
      case _ => throw new Exception("")
    }

    def reverseList(node: ListNode): (ListNode, ListNode) = {
      if (node == null) (null, null)
      else if (node.next != null) {
        val res = reverseList(node.next)
        res._1.next = node
        node.next = null
        (node, res._2)
      }
      else (node, node)
    }

    @scala.annotation.tailrec
    def merge(node1: ListNode, node2: ListNode): Unit = {
      val temp1 = node1.next
      val temp2 = if (node2 != null) node2.next else null

      node1.next = node2
      node2.next = temp1

      if (temp2 != null) merge(temp1, temp2)
    }

    if (head != null && head.next != null) merge(head, reverseList(cut(head)._1)._2)
  }
}
