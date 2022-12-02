package leetCode

object Solution_2487 {
  def removeNodes(head: ListNode): ListNode = {
    def f(curr: ListNode): ListNode =
      if (curr == null) curr
      else {
        curr.next = f(curr.next)
        if (curr.next != null && curr.x < curr.next.x) curr.next
        else curr
      }

    f(head)
  }
}
