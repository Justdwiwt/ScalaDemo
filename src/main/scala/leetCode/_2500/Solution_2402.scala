package leetCode._2500

import scala.collection.mutable

object Solution_2402 {
  def mostBooked(n: Int, meetings: Array[Array[Int]]): Int = {
    val sorted = meetings.sortBy(_.head)

    val pq = mutable.PriorityQueue.empty[Int]

    pq.enqueue((0 until n).map(x => -x): _*)

    val assignment = mutable.PriorityQueue.empty[(Long, Int)]
    val counter = mutable.Map[Int, Int]((0 until n).map(x => (-x, 0)): _*)

    sorted.foreach(mt => {
      while (assignment.nonEmpty && mt.head >= -assignment.head._1) {
        val (_, rid) = assignment.dequeue
        pq.enqueue(rid)
      }
      if (pq.nonEmpty) {
        val rid = pq.dequeue
        counter(rid) += 1
        assignment.enqueue((-mt(1), rid))
      } else {
        val (endT, rid) = assignment.dequeue
        counter(rid) += 1
        assignment.enqueue((-(-endT + mt(1) - mt.head), rid))
      }
    })
    -counter.toList.map(p => (p._2, p._1)).max._2
  }
}
