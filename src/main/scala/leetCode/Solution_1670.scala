package leetCode

import scala.collection.mutable

object Solution_1670 {

  class ListNode(val `val`: Int) {
    var pre: ListNode = _
    var next: ListNode = _
  }

  class FrontMiddleBackQueue() {
    var head: ListNode = _
    var tail: ListNode = _
    var mid: ListNode = _
    var length = 0

    private[this] def pushFirst(`val`: Int) {
      assert(length == 0 && head == null && mid == null && tail == null)
      head = new ListNode(`val`)
      mid = head
      tail = head
      length += 1
    }

    def pushFront(`val`: Int) {
      if (length == 0) pushFirst(`val`)
      else {
        val _head = head
        head = new ListNode(`val`)
        head.next = _head
        head.next.pre = head
        if (length % 2 == 1) mid = mid.pre
        length += 1
      }
      debugPrint()
    }

    def pushMiddle(`val`: Int) {
      if (length == 0) pushFirst(`val`)
      else if (length % 2 == 0) {
        val next = mid.next
        mid.next = new ListNode(`val`)
        mid.next.pre = mid
        mid.next.next = next
        if (next != null) next.pre = mid.next
        mid = mid.next
        length += 1
      }
      else {
        val prev = mid.pre
        mid.pre = new ListNode(`val`)
        mid.pre.next = mid
        mid.pre.pre = prev
        if (prev != null) prev.next = mid.pre
        if (head == mid) head = mid.pre
        mid = mid.pre
        length += 1
      }
      debugPrint()
    }

    def pushBack(`val`: Int) {
      if (length == 0) pushFirst(`val`)
      else {
        tail.next = new ListNode(`val`)
        tail.next.pre = tail
        tail = tail.next
        length += 1
        if (length % 2 == 1) mid = mid.next
      }
      debugPrint()
    }

    private[this] def popLast(): Int = {
      assert(length == 1)
      val `val` = head.`val`
      head = null
      mid = null
      tail = null
      length -= 1
      `val`
    }

    def popFront(): Int = {
      if (head == null) {
        debugPrint()
        -1
      }
      else if (length == 1) {
        val `val` = popLast()
        debugPrint()
        `val`
      }
      else {
        val `val` = head.`val`
        head = head.next
        length -= 1
        if (length % 2 == 1) mid = mid.next
        debugPrint()
        `val`
      }
    }

    def popMiddle(): Int = {
      if (mid == null) {
        debugPrint()
        -1
      } else if (length == 1) {
        val `val` = popLast()
        debugPrint()
        `val`
      } else {
        val `val` = mid.`val`
        if (mid.next != null) mid.next.pre = mid.pre
        if (mid.pre != null) mid.pre.next = mid.next
        if (length % 2 == 0) {
          if (head == mid) head = head.next
          mid = mid.next
        }
        else mid = mid.pre
        length -= 1
        debugPrint()
        `val`
      }
    }

    def popBack(): Int = {
      if (tail == null) {
        debugPrint()
        -1
      } else if (length == 1) {
        val `val` = popLast()
        debugPrint()
        `val`
      } else {
        val `val` = tail.`val`
        tail = tail.pre
        tail.next = null
        length -= 1
        if (length % 2 == 0) mid = mid.pre
        debugPrint()
        `val`
      }
    }

    private[this] def debugPrint(): Unit = {

      def nodeToString(node: ListNode): String = {
        val componentAcc = mutable.ArrayBuffer[String]()
        if (node == head) componentAcc.append("(head)")
        if (node == mid) componentAcc.append("(middle)")
        if (node == tail) componentAcc.append("(tail)")
        componentAcc.append(node.`val`.toString)
        componentAcc.mkString("")
      }

      if (false) {
        var p = head
        val acc = mutable.ArrayBuffer[String]()
        while (p != null) {
          acc.append(nodeToString(p))
          p = p.next
        }
        println("Queue: " + acc.mkString(" -> ") + f" (#=$length)")
        p = tail
        acc.clear()
        while (p != null) {
          acc.append(nodeToString(p))
          p = p.pre
        }
        println("(Reversed): " + acc.mkString(" -> ") + f" (#=$length)")
      }
    }
  }

}
