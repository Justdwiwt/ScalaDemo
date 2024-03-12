package leetCode._300

object Solution_234 {

  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  }

  def isPalindrome(head: ListNode): Boolean = {
    if (head == null || head.next == null) return true
    cmp(head, rec(head)._1, math.ceil(rec(head)._2 / 2).toInt)
  }

  @scala.annotation.tailrec
  def rec(head: ListNode, reversed: ListNode = null, length: Int = 0): (ListNode, Int) = head match {
    case null => (reversed, length)
    case link => rec(link.next, new ListNode(link.x, reversed), length + 1)
  }

  @scala.annotation.tailrec
  def cmp(listA: ListNode, listB: ListNode, comparisonsLeft: Int): Boolean =
    if (comparisonsLeft == 0) true
    else if (listA.x != listB.x) false
    else cmp(listA.next, listB.next, comparisonsLeft - 1)

}
