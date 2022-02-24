package leetCode

object Solution_2181 {
  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  }

  def mergeNodes(head: ListNode): ListNode = {
    def f(cur: ListNode, sum: Int): ListNode =
      if (cur == null) null
      else if (cur.x > 0) f(cur.next, sum + cur.x)
      else new ListNode(sum, f(cur.next, sum = 0))

    f(head.next, sum = 0)
  }
}
