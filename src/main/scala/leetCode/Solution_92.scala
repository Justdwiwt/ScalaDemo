package leetCode

object Solution_92 {
  def reverseBetween(head: ListNode, m: Int, n: Int): ListNode = {
    if (m == n) return head
    var diff = Array.emptyIntArray
    var tmp = head
    while (tmp != null) {
      diff = diff :+ tmp.x
      tmp = tmp.next
    }
    val (start, body, end) = (diff.slice(0, m - 1), diff.slice(m - 1, n), diff.slice(n, diff.length))
    val arr = (start ++ body.reverse ++ end).map(new ListNode(_))
    val res = arr.head
    arr.reduceLeft({ (x, y) => x.next = y; y })
    res
  }
}
