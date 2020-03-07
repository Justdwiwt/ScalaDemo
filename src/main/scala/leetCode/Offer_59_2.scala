package leetCode

import java.util

object Offer_59_2 {

  class MaxQueue() {

    var q: util.Queue[Int] = new util.LinkedList[Int]()
    var dq: util.Deque[Int] = new util.LinkedList[Int]()

    def max_value(): Int = if (dq.size() > 0) dq.peek() else -1

    def push_back(value: Int) {
      q.offer(value)
      while (dq.size() > 0 && dq.peekLast() < value) dq.pollLast()
      dq.offerLast(value)
    }

    def pop_front(): Int = {
      val t = if (q.size() > 0) q.poll() else -1
      if (dq.size() > 0 && t == dq.peek()) dq.poll()
      t
    }

  }

}
