package leetCode._800

object Solution_707 {
  class ListNode(_value: Int) {
    var value: Int = _value
    var next: ListNode = _
  }

  class MyLinkedList() {
    var size = 0
    var head: ListNode = new ListNode(0)

    def get(index: Int): Int = {
      if (index < 0 || index >= size) return -1
      var cur: ListNode = head
      Range(0, index + 1, 1).foreach(i => cur = cur.next)
      cur.value
    }

    def addAtHead(`val`: Int): Unit = {
      addAtIndex(0, `val`)
    }

    def addAtTail(`val`: Int): Unit = {
      addAtIndex(size, `val`)
    }

    private def addAtIndex(_index: Int, `val`: Int): Unit = {
      var index = _index
      if (index > size) return
      index = 0.max(index)
      size += 1
      var pred: ListNode = head
      Range(0, index, 1).foreach(i => pred = pred.next)
      val toAdd: ListNode = new ListNode(`val`)
      toAdd.next = pred.next
      pred.next = toAdd
    }

    def deleteAtIndex(index: Int): Unit = {
      if (index < 0 || index >= size) return
      size -= 1
      var pred: ListNode = head
      Range(0, index, 1).foreach(_ => pred = pred.next)
      pred.next = pred.next.next
    }
  }
}
