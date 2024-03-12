package leetCode.offer

import scala.collection.mutable

object Offer_35 {
  def copyRandomList(head: Node): Node = {
    var cur = head
    val m = new mutable.HashMap[Node, Node]()
    while (cur != null) {
      val node = new Node(cur.`val`)
      m.put(cur, node)
      cur = cur.next
    }
    cur = head
    while (cur != null) {
      val node = m(cur)
      node.next = m(cur.next)
      node.random = m(cur.random)
      cur = cur.next
    }
    m(head)
  }

  class Node(_val: Int) {
    var `val`: Int = _val
    var next: Node = _
    var random: Node = _
  }

}
