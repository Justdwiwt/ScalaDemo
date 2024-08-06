package leetCode._3300

import scala.collection.mutable

object Solution_3237 {
  def simulationResult(windows: Array[Int], queries: Array[Int]): Array[Int] = {
    val res = mutable.LinkedHashSet(windows.reverse: _*)

    queries.foreach(v => {
      res -= v
      res += v
    })

    res.toArray.reverse
  }
}
