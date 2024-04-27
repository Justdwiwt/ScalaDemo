package leetCode._1900

import leetCode.ListNode

import scala.collection.mutable

object Solution_1836 {
  def deleteDuplicatesUnsorted(head: ListNode): ListNode = {
    if (head == null || head.next == null) return head

    val occurrences = countOccurrences(head)
    removeDuplicates(head, occurrences)
  }

  private def countOccurrences(head: ListNode): mutable.Map[Int, Int] = {
    @scala.annotation.tailrec
    def f(node: ListNode, map: mutable.Map[Int, Int]): mutable.Map[Int, Int] =
      if (node == null) map
      else {
        val currentCount = map.getOrElse(node.x, 0)
        map.update(node.x, currentCount + 1)
        f(node.next, map)
      }

    f(head, mutable.Map.empty[Int, Int])
  }

  private def removeDuplicates(head: ListNode, occurrences: mutable.Map[Int, Int]): ListNode = {
    val dummyHead = new ListNode(0)
    dummyHead.next = head
    var cur = dummyHead

    while (cur != null && cur.next != null) {
      if (occurrences(cur.next.x) > 1) cur.next = cur.next.next
      else cur = cur.next
    }

    dummyHead.next
  }
}
