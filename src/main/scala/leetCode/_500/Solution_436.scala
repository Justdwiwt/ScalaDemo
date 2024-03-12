package leetCode._500

object Solution_436 {
  def findRightInterval(intervals: Array[Array[Int]]): Array[Int] = {
    @scala.annotation.tailrec
    def f(tuple: Array[(Array[Int], Int)], interval: Array[Int], start: Int, end: Int): Int =
      if (start == end)
        if (start == tuple.length) -1
        else tuple(start)._2
      else {
        val mid = start + (end - start) / 2
        if (tuple(mid)._1.head >= interval(1)) f(tuple, interval, start, mid)
        else f(tuple, interval, mid + 1, end)
      }

    val tuple = intervals.zipWithIndex.sortWith((a, b) => a._1.head < b._1.head)
    intervals.map(interval => f(tuple, interval, 0, tuple.length))
  }
}
