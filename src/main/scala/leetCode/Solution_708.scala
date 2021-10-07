package leetCode

object Solution_708 {
  class Node(var _value: Int) {
    var value: Int = _value
    var next: Node = _
  }

  def insert(head: Node, insertVal: Int): Node = {
    if (head == null) {
      val newHead = new Node(insertVal)
      newHead.next = newHead
      return newHead
    }
    var mx: Node = null
    var cur = head
    do {
      if (insertVal >= cur.value && insertVal <= cur.next.value) {
        val tmp = new Node(insertVal)
        tmp.next = cur.next
        cur.next = tmp
        return head
      }
      if (cur.value > cur.next.value) mx = cur
      cur = cur.next
    } while (cur != head)
    mx = if (mx == null) cur else mx
    val tmp = new Node(insertVal)
    tmp.next = mx.next
    mx.next = tmp
    head
  }
}
