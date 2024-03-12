package leetCode._400

import leetCode.ListNode

object Solution_382 {

  class Solution(_head: ListNode) {

    def getRandom: Int = {
      @annotation.tailrec
      def loop(head: ListNode, count: Int, res: Int): Int =
        if (head == null) res
        else {
          if (util.Random.nextInt(count) == 0) loop(head.next, count + 1, head.x)
          else loop(head.next, count + 1, res)
        }

      loop(_head, 1, -1)
    }

  }

}
