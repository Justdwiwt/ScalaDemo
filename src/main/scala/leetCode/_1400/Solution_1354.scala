package leetCode._1400

import scala.collection.mutable

object Solution_1354 {
  def isPossible(target: Array[Int]): Boolean = {
    val pq = mutable.PriorityQueue(target: _*)

    @scala.annotation.tailrec
    def f(sum: Int = pq.sum): Boolean = pq.dequeue() match {
      case max if max == 1 || sum - max == 1 => true
      case max => max % (sum - max) match {
        case next if next == 0 || next == max => false
        case next => pq.enqueue(next)
          f(sum - max + next)
      }
    }

    if (target.length == 1) target.head == 1 else f()
  }
}
