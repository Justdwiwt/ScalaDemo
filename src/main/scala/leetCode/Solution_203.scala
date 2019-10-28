package leetCode

object Solution_203 {
  def removeElements(head: ListNode, `val`: Int): ListNode = {
    val res = new ListNode(`val` - 1)
    res.next = head
    var prev = res
    while (prev.next != null)
      if (prev.next.x == `val`) prev.next = prev.next.next
      else prev = prev.next
    res.next
  }
}
