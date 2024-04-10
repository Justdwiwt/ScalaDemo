package leetCode._3100

import leetCode.ListNode

import scala.collection.mutable

object Solution_3063 {
  def frequenciesOfElements(head: ListNode): ListNode = {
    val counts = mutable.Map.empty[Int, Int]
    var node = head
    while (node != null) {
      counts(node.x) = counts.getOrElse(node.x, 0) + 1
      node = node.next
    }
    val dummyHead = new ListNode(0)
    var temp = dummyHead
    counts.foreach { case (_, count) =>
      temp.next = new ListNode(count)
      temp = temp.next
    }
    dummyHead.next
  }
}
