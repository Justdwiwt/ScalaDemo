package leetCode

import scala.collection.mutable

object Offer_06 {
  def reversePrint(head: ListNode): Array[Int] = {
    var res = Array.empty[Int]
    val st = new mutable.Stack[Int]
    var t = head
    while (t != null) {
      st.push(t.x)
      t = t.next
    }
    while (st.nonEmpty) {
      res :+= st.head
      st.pop()
    }
    res
  }
}
