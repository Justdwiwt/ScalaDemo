package leetCode._1500

import leetCode.ListNode

object Solution_1474 {
  def deleteNodes(head: ListNode, m: Int, n: Int): ListNode = {
    val dummy = new ListNode(0)
    dummy.next = head

    @scala.annotation.tailrec
    def f(cur: ListNode, p: Int, q: Int): Unit = {
      if (cur.next == null) return

      var tempCur = cur
      var tempP = p
      var tempQ = q

      while (tempP > 0 && tempCur.next != null) {
        tempP -= 1
        tempCur = tempCur.next
      }

      while (tempQ > 0 && tempCur.next != null) {
        tempQ -= 1
        tempCur.next = tempCur.next.next
      }

      f(tempCur, p, q)
    }

    f(dummy, m, n)
    dummy.next
  }
}
