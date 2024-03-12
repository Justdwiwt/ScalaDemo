package leetCode._2200

import leetCode.ListNode

object Solution_2130 {
  def pairSum(head: ListNode): Int = {
    @scala.annotation.tailrec
    def length(cur: ListNode, len: Int): Int =
      if (cur == null) len
      else length(cur.next, len + 1)

    val len = length(head, 0)

    @scala.annotation.tailrec
    def findMid(cur: ListNode, idx: Int): ListNode =
      if (idx == len / 2 - 1) cur
      else findMid(cur.next, idx + 1)

    val mid = findMid(head, 0)

    @scala.annotation.tailrec
    def reverse(pre: ListNode, cur: ListNode): ListNode = {
      val next = cur.next
      cur.next = pre
      if (next == null) cur else reverse(cur, next)
    }

    val last = reverse(mid, mid.next)

    (0 until len / 2)./:(head, last, 0) {
      case ((head, last, prevMax), _) =>
        (head.next, last.next, prevMax.max(head.x + last.x))
    }._3
  }
}
