package leetCode

object Code_02_06 {
  def isPalindrome(head: ListNode): Boolean = {
    val t = reverse(head)
    check(head, t)
  }

  def reverse(node: ListNode): ListNode = {
    var head: ListNode = null
    var n = node
    while (n != null) {
      val v = new ListNode(n.x)
      v.next = head
      head = v
      n = n.next
    }
    head
  }

  def check(l1: ListNode, l2: ListNode): Boolean = {
    var one = l1
    var two = l2
    while (one != null && two != null) {
      if (one.x != two.x) return false
      one = one.next
      two = two.next
    }
    one == null && two == null
  }
}
