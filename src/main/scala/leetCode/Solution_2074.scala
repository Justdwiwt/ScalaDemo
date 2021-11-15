package leetCode

import scala.collection.mutable.ArrayBuffer

object Solution_2074 {
  def reverseEvenLengthGroups(head: ListNode): ListNode = {
    var group = 1
    var run = head

    val res = new ListNode
    var tttt = res

    while (run != null) {
      var size = 0

      val temp = new ArrayBuffer[Int]
      while (size < group && run != null) {
        temp += run.x
        run = run.next
        size += 1
      }
      if (size % 2 == 0) {
        temp.indices.reverse.foreach(i => {
          val t = new ListNode(temp(i))
          tttt.next = t
          tttt = tttt.next
        })
      } else {
        temp.indices.foreach(i => {
          val t = new ListNode(temp(i))
          tttt.next = t
          tttt = tttt.next
        })
      }
      group += 1
    }

    res.next
  }
}
