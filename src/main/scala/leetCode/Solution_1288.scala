package leetCode

object Solution_1288 {
  def removeCoveredIntervals(intervals: Array[Array[Int]]): Int = {
    val t = intervals.sortWith((a, b) => if (a(1) == b(1)) a(0) < b(0) else a(1) > b(1))
    var l = t(0)(0)
    var r = t(0)(1)
    var res = 1
    (1 until t.length).foreach(i => {
      if (t(i)(0) < l) {
        res += 1
        l = t(i)(0)
        r = t(i)(1)
      }
    })
    res
  }
}
