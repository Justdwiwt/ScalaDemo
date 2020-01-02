package leetCode

object Solution_435 {
  def eraseOverlapIntervals(intervals: Array[Array[Int]]): Int = {
    if (intervals.isEmpty) return 0
    val arr = intervals.sortWith(_.head > _.head)
    var res = 1
    var end = arr(0)(1)
    arr.foreach(i => {
      val start = i(0)
      if (start >= end) {
        res += 1
        end = i(1)
      }
    })
    res
  }
}
