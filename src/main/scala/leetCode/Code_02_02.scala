package leetCode

object Code_02_02 {
  def kthToLast(head: ListNode, k: Int): Int = {
    var p = head
    (0 until k).foreach(_ => p = p.next)
    var q = head
    while (p != null) {
      p = p.next
      q = q.next
    }
    q.x
  }
}
