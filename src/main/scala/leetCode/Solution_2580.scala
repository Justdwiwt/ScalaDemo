package leetCode

object Solution_2580 {
  def countWays(ranges: Array[Array[Int]]): Int = ranges
    .sortBy(_.head)
    ./:(1, -1) { case ((res, last), Array(l, r)) =>
      if (last >= l) (res, last.max(r))
      else (res * 2 % 1000000007, last.max(r))
    }
    ._1
}
