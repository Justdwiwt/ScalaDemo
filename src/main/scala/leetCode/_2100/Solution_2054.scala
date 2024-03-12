package leetCode._2100

import scala.collection.mutable

object Solution_2054 {
  def maxTwoEvents(events: Array[Array[Int]]): Int = {
    val sorted = events.sortBy(_.head)

    implicit val ord: Ordering[Array[Int]] = (x, y) => y(1).compare(x(1))
    val pq = mutable.PriorityQueue.empty[Array[Int]]

    var (overallMax, completeMax) = (0, 0)
    sorted.foreach(v => {
      while (pq.nonEmpty && pq.head(1) < v.head)
        completeMax = completeMax.max(pq.dequeue()(2))
      overallMax = overallMax.max(completeMax + v(2))
      pq += v
    })

    overallMax
  }
}
