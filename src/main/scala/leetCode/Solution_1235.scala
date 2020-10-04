package leetCode

import java.util

import scala.collection.mutable

object Solution_1235 {
  def jobScheduling(startTime: Array[Int], endTime: Array[Int], profit: Array[Int]): Int = {
    val dp = new util.TreeMap[Int, Int]()
    val pq = mutable.PriorityQueue[(Int, Int, Int)]()((x, y) => y._2 - x._2)
    var res = 0
    startTime.indices.foreach(i => pq += ((startTime(i), endTime(i), profit(i))))
    startTime.indices.foreach(_ => {
      val (s, e, p) = pq.dequeue()
      dp.put(e, p.max(dp.getOrDefault(if (dp.floorKey(e) != 0) dp.floorKey(e) else 0, 0)))
      if (dp.floorKey(s) != 0) {
        val v = dp.get(e).max(dp.get(dp.floorKey(s)) + p)
        dp.put(e, v)
      }
      res = res.max(dp.get(e))
    })
    res
  }
}
