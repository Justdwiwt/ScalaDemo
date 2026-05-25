package leetCode._1900

import scala.collection.immutable.Queue

object Solution_1871 {
  def canReach(s: String, minJump: Int, maxJump: Int): Boolean = {
    @scala.annotation.tailrec
    def f(q: Queue[Int], next: Int): Boolean =
      if (q.isEmpty || q.head >= s.length) false
      else if (q.head == s.length - 1) true
      else if (s(q.head) == '1') f(q.tail, next)
      else f(q.tail ++ Iterator.range(next.max(q.head + minJump), q.head + maxJump + 1), q.head + maxJump + 1)

    s.last == '0' && f(Queue(0), 1)
  }
}
