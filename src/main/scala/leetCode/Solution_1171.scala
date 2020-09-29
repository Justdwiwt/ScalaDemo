package leetCode

import scala.collection.mutable

object Solution_1171 {
  def removeZeroSumSublists(head: ListNode): ListNode = {
    val s = mutable.Set[Int]()
    s += 0
    val res = new ListNode(-1)
    res.next = head

    val st = mutable.Stack[ListNode]()
    var runner = head
    var sum = 0

    while (runner != null) {

      val currVal = runner.x
      val curr = runner
      sum += currVal

      if (s.add(sum)) st.push(curr)
      else {
        val next = curr.next
        val tmpSum = sum
        sum -= currVal

        while (st.nonEmpty && tmpSum != sum) {
          s.remove(sum)
          sum -= st.pop().x
        }

        if (st.nonEmpty) st.top.next = next
        else res.next = next
      }
      runner = runner.next
    }
    res.next
  }
}
