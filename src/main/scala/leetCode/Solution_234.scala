package leetCode

object Solution_234 {
  def isPalindrome(head: ListNode): Boolean = {
    if (head == null || head.next == null) return true
    var pre: ListNode = null
    var slow: ListNode = head
    var fast: ListNode = head
    var s: ListNode = null
    while (fast != null && fast.next != null) {
      pre = slow
      slow = slow.next
      fast = fast.next.next
      pre.next = s
      s = pre
    }
    var tmp: ListNode = slow
    if (fast != null) tmp = tmp.next
    slow = pre
    while (tmp != null) {
      if (tmp.x != slow.x) return false
      else {
        tmp = tmp.next
        slow = slow.next
      }
    }
    true
  }
}
