package leetCode

object Solution_203 {
  @scala.annotation.tailrec
  def removeElements(head: ListNode, `val`: Int, prev: ListNode = null, ans: ListNode = null): ListNode =
    if (head == null) ans
    else if (head.x == `val`) {
      if (prev != null) prev.next = head.next
      removeElements(head.next, `val`, prev, ans)
    }
    else removeElements(head.next, `val`, head, if (ans == null) head else ans)
}
