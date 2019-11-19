package leetCode

import scala.collection.mutable.ArrayBuffer

object Solution_57 {
  def insert(intervals: Array[Array[Int]], newInterval: Array[Int]): Array[Array[Int]] = {
    val res = ArrayBuffer[Array[Int]]()
    var cur = 0
    while (cur < intervals.length && intervals(cur)(1) < newInterval(0)) {
      res.append(intervals(cur))
      cur += 1
    }
    while (cur < intervals.length && intervals(cur)(0) <= newInterval(1)) {
      newInterval(0) = newInterval(0).min(intervals(cur)(0))
      newInterval(1) = newInterval(1).max(intervals(cur)(1))
      cur += 1
    }
    res.append(newInterval)
    while (cur < intervals.length) {
      res.append(intervals(cur))
      cur += 1
    }
    res.toArray
  }
}
