package leetCode._3400

object Solution_3394 {
  def checkValidCuts(n: Int, rectangles: Array[Array[Int]]): Boolean = {
    def check(intervals: Array[(Int, Int)]): Boolean = {
      val sorted = intervals.sortBy(_._1)
      var cnt = 0
      var mxR = 0
      sorted.foreach { case (l, r) =>
        if (l >= mxR) cnt += 1
        if (r > mxR) mxR = r
      }
      cnt >= 3
    }

    val xIntervals = rectangles.map { case Array(sx, _, ex, _) => (sx, ex) }
    val yIntervals = rectangles.map { case Array(_, sy, _, ey) => (sy, ey) }

    check(xIntervals) || check(yIntervals)
  }
}
