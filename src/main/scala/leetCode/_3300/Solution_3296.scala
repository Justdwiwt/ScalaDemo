package leetCode._3300

import scala.collection.mutable

object Solution_3296 {
  def minNumberOfSeconds(mountainHeight: Int, workerTimes: Array[Int]): Long = {
    implicit val ord: Ordering[(Long, Long, Long)] = Ordering.by(-_._1)
    val pq = mutable.PriorityQueue(workerTimes.map(t => (t.toLong, t.toLong, t.toLong)): _*)

    var res = 0L
    (0 until mountainHeight).foreach(_ => {
      val (next, delta, base) = pq.dequeue()
      res = next
      pq += ((next + delta + base, delta + base, base))
    })
    res
  }
}
