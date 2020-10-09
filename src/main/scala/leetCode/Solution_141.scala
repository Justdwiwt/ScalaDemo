package leetCode

object Solution_141 {
  @scala.annotation.tailrec
  def f(p: ListNode, q: ListNode): Boolean = q match {
    case q if p != q => q match {
      case q if q == null || q.next == null => false
      case _ => f(p.next, q.next.next)
    }
    case _ => true
  }

  def hasCycle(head: ListNode): Boolean = head match {
    case head if head == null || head.next == null => false
    case head => f(head, head.next)
  }
}
