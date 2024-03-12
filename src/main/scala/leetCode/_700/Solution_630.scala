package leetCode._700

import scala.collection.mutable

object Solution_630 {
  def scheduleCourse(courses: Array[Array[Int]]): Int = {
    var time = 0
    val sorted = courses.sortBy(_ (1))
    val pq = mutable.PriorityQueue[Int]()
    sorted.foreach(i => {
      time += i(0)
      pq += i(0)
      if (time > i(1)) time -= pq.dequeue
    })
    pq.size
  }
}
