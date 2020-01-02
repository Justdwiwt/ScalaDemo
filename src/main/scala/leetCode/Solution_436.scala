package leetCode

import scala.collection.mutable
import scala.util.control.Breaks._

object Solution_436 {
  def findRightInterval(intervals: Array[Array[Int]]): Array[Int] = {
    var res = Array.empty[Int]
    var starts = Array.empty[Int]
    val m = new mutable.HashMap[Int, Int]()
    intervals.indices.foreach(i => {
      m(intervals(i)(0)) = i
      starts :+= intervals(i)(0)
    })
    val t = starts.sorted.reverse
    intervals.foreach(v => {
      var i = 0
      breakable {
        while (i < t.length) {
          if (t(i) < v(1)) break
          i += 1
        }
      }
      res :+= (if (i > 0) m(t(i - 1)) else -1)
    })
    res
  }
}
