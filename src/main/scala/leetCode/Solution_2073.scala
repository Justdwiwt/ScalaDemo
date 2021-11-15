package leetCode

import scala.collection.mutable

object Solution_2073 {
  def timeRequiredToBuy(tickets: Array[Int], k: Int): Int = {
    val q = mutable.Queue.empty[(Int, Int)]
    tickets.zipWithIndex.foreach({ case (v, i) => q += ((v, i)) })
    var res = 0
    while (q.nonEmpty) {
      val cur = q.dequeue
      res += 1
      if (cur._1 == 1 && cur._2 == k) return res
      if (cur._1 > 1) q += ((cur._1 - 1, cur._2))
    }
    res
  }
}
