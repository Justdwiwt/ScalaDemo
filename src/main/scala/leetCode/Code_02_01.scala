package leetCode

import scala.collection.mutable

object Code_02_01 {
  def removeDuplicateNodes(head: ListNode): ListNode = head match {
    case null => head
    case _ =>
      val s = new mutable.HashSet[Int]()
      var p = head
      s.add(p.x)
      while (p.next != null) {
        if (s.contains(p.next.x)) p.next = p.next.next
        else {
          s.add(p.next.x)
          p = p.next
        }
      }
      head
  }
}
