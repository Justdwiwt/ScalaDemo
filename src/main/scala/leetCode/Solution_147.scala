package leetCode

object Solution_147 {
  def insertionSortList(head: ListNode): ListNode = {
    val dummy = new ListNode(-1)
    var cur = dummy
    var root = head
    while (root != null) {
      val t = root.next
      cur = dummy
      while (cur.next != null && cur.next.x <= root.x) cur = cur.next
      root.next = cur.next
      cur.next = root
      root = t
    }
    dummy.next
  }
}
