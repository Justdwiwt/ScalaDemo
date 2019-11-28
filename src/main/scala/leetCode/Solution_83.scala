package leetCode

object Solution_83 {
  def deleteDuplicates(head: ListNode): ListNode = {
    if (head == null || head.next == null) return head
    head.next = deleteDuplicates(head.next)
    if (head.x == head.next.x) head.next else head
  }
}
