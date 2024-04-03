package leetCode._700

import scala.collection.mutable

object Solution_630 {
  def scheduleCourse(courses: Array[Array[Int]]): Int = {
    val pq = mutable.PriorityQueue.empty[Int]
    courses.sortBy(_(1)).foldLeft(0) { case (totalDuration, Array(duration, lastDay)) =>
      pq.enqueue(duration)
      if (totalDuration + duration > lastDay) totalDuration + duration - pq.dequeue() else totalDuration + duration
    }
    pq.size
  }
}
