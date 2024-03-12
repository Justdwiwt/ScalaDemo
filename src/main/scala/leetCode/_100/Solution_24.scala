package leetCode._100

object Solution_24 {
  def swapPairs(head: ListNode): ListNode = {
    if (head == null || head.next == null) return head
    val next = head.next
    head.next = swapPairs(next.next)
    next.next = head
    next
  }
}
