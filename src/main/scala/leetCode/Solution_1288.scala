package leetCode

object Solution_1288 {
  def removeCoveredIntervals(intervals: Array[Array[Int]]): Int = intervals
    .sortWith((a, b) => a.head < b.head || (a.head == b.head && a(1) >= b(1)))
    ./:((0, 0)) { case (res@(pre, cnt), Array(_, end)) =>
      if (end > pre) (end, cnt + 1) else res
    }._2
}
