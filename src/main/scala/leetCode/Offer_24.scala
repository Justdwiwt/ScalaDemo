package leetCode

object Offer_24 {
  def reverseList(head: ListNode): ListNode = {
    if (head == null || head.next == null) return head
    val cur = reverseList(head.next)
    head.next.next = head
    head.next = null
    cur
  }
}
