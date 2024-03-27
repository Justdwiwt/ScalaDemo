package leetCode._1400

object Solution_1326 {
  def minTaps(n: Int, ranges: Array[Int]): Int = {
    val arr = Array.tabulate(n + 1)(i => (i - ranges(i), i + ranges(i)))

    @scala.annotation.tailrec
    def f(openTaps: Int, maxRight: Int, i: Int): Int =
      if (maxRight >= n) openTaps
      else arr.filter(interval => interval._1 <= maxRight && interval._2 > maxRight) match {
        case x if x.isEmpty => -1
        case x => f(openTaps + 1, x.maxBy(_._2)._2, i + 1)
      }

    f(0, 0, 0)
  }
}
