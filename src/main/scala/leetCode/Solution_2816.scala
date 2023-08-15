package leetCode

object Solution_2816 {
  def doubleIt(head: ListNode): ListNode = {
    if (f(head)) {
      val res = new ListNode(1)
      res.next = head
      res
    } else head
  }

  private def f(node: ListNode): Boolean = {
    if (node == null) return false
    val v = node.x * 2 + (if (f(node.next)) 1 else 0)
    node.x = v % 10
    if (v > 9) true else false
  }
}
