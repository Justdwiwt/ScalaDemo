package leetCode.offer

object Offer_028 {
  class Node(var _value: Int) {
    var value: Int = _value
    var prev: Node = _
    var next: Node = _
    var child: Node = _
  }

  def flatten(head: Node): Node = {
    if (head == null) return head
    var cur = head
    while (cur != null) {
      if (cur.child != null) {
        val childNode = cur.child
        val nextNode = cur.next
        cur.child = null
        cur.next = null
        var retNode = flatten(childNode)
        retNode.prev = cur
        cur.next = retNode
        while (retNode.next != null) retNode = retNode.next
        retNode.next = nextNode
        if (nextNode != null) nextNode.prev = retNode
      } else cur = cur.next
    }
    head
  }
}
