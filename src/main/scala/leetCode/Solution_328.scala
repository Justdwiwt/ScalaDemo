package leetCode

object Solution_328 {
  def oddEvenList(head: ListNode): ListNode = {
    if (head == null || head.next == null) return head
    var odd = head
    var even = head.next
    val evenHead = even
    while (even != null && even.next != null) {
      odd.next = even.next
      odd = odd.next
      even.next = odd.next
      even = even.next
    }
    odd.next = evenHead
    head
  }
}
