package leetCode._2500

import scala.collection.mutable

object Solution_2406 {
  def minGroups(intervals: Array[Array[Int]]): Int = {
    val tm = mutable.TreeMap[Int, Int]().withDefaultValue(0)
    intervals
      .withFilter { case Array(_, _) => true; case _ => false }
      .foreach { case Array(s, e) =>
        tm(s) += 1
        tm(e + 1) -= 1
      }
    var res = 0
    var cur = 0
    tm.values.foreach(v => {
      cur += v
      res = cur.max(res)
    })
    res
  }
}
