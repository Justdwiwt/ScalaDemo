package leetCode

import scala.collection.mutable

object Solution_659 {
  def isPossible(nums: Array[Int]): Boolean = {
    if (nums.length <= 2) return false
    val m = mutable.Map[Int, mutable.PriorityQueue[Int]]()
    nums.foreach(i => if (!m.contains(i - 1))
      if (!m.contains(i)) m(i) = mutable.PriorityQueue(1)(Ordering[Int].reverse)
      else m(i) += 1
    else {
      val size = m(i - 1).dequeue
      if (m(i - 1).isEmpty) m.remove(i - 1)
      if (!m.contains(i)) m(i) = mutable.PriorityQueue(size + 1)(Ordering[Int].reverse)
      else m(i) += (size + 1)
    })
    m.values.forall(_.forall(_ >= 3))
  }
}
