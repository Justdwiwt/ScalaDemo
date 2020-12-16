package leetCode

object Solution_725 {
  def splitListToParts(root: ListNode, k: Int): Array[ListNode] =
    if (k == 0) Array.empty
    else if (k == 1) Array(root)
    else {
      val n = g(root)
      val size = n / k
      var mod = n % k
      (1 until k)./:(Array(root)) { (acc, _) =>
        val cur = if (mod > 0) 1 else 0
        val last = f(acc.last, size + cur - 1)
        val next = if (last != null) last.next else null
        if (last != null) last.next = null
        mod -= 1
        acc :+ next
      }
    }

  @scala.annotation.tailrec
  def f(node: ListNode, n: Int): ListNode =
    if (node == null) node
    else if (n == 0) node
    else if (node.next == null) null
    else f(node.next, n - 1)

  @scala.annotation.tailrec
  def g(root: ListNode, size: Int = 1): Int =
    if (root == null) 0
    else if (root.next == null) size
    else g(root.next, size + 1)
}
