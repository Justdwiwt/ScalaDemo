package leetCode._900

import scala.collection.mutable

object Solution_857 {
  def mincostToHireWorkers(quality: Array[Int], wage: Array[Int], k: Int): Double = {
    val sorted = quality.zipWithIndex.map { case (v, i) => (wage(i).toDouble / v, v) }.sortBy(_._1)
    val firstKQualities = sorted.take(k).map(_._2)
    var sum = firstKQualities.sum
    var res: Double = sum * sorted(k - 1)._1
    val pq = mutable.PriorityQueue[Int](firstKQualities: _*)
    (k until quality.length).foreach(i => {
      val curr = sorted(i)
      if (pq.head > curr._2) {
        val removedQuality = pq.dequeue
        pq += curr._2
        sum += curr._2 - removedQuality
      }
      res = res.min(sum * curr._1)
    })
    res
  }
}
