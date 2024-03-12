package leetCode._2900

import scala.collection.immutable.Queue

object Solution_2855 {
  def minimumRightShifts(nums: List[Int]): Int = nums.reverse match {
    case n1 :: tail => f(n1, Queue(tail: _*), 0, nums.size)
    case _ => 0
  }

  @scala.annotation.tailrec
  private def f(n1: Int, queue: Queue[Int], steps: Int, size: Int): Int =
    if (steps == size) -1
    else if (g(n1, queue)) steps
    else f(queue.head, queue.tail :+ n1, steps + 1, size)

  @scala.annotation.tailrec
  private def g(n1: Int, q: Queue[Int]): Boolean =
    if (q.isEmpty) true
    else n1 > q.head && g(q.head, q.tail)
}
