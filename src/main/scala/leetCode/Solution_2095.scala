package leetCode

object Solution_2095 {
  def deleteMiddle(head: ListNode): ListNode = {
    if (head != null && head.next == null) return null
    var slow = head
    var fast = head
    var pre = head
    while (fast != null && fast.next != null) {
      pre = slow
      slow = slow.next
      fast = fast.next.next
    }
    pre.next = slow.next
    head
  }
}
