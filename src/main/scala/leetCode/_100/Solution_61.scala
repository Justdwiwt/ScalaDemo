package leetCode._100

object Solution_61 {
  def rotateRight(head: ListNode, k: Int): ListNode = head match {
    case null => null
    case _ =>
      var n = 1
      var cur = head
      while (cur.next != null) {
        n += 1
        cur = cur.next
      }
      cur.next = head
      val m = n - k % n
      (0 until m).foreach(_ => cur = cur.next)
      val newHead = cur.next
      cur.next = null
      newHead
  }
}
