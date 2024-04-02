package leetCode._800

object Solution_757 {
  def intersectionSizeTwo(intervals: Array[Array[Int]]): Int = intervals
    .sortBy(x => (x(1), -x(0)))
    .foldLeft((-1, -1, 0)) { case ((p1, p2, res), x) =>
      if (x.head > p1) {
        if (x.head > p2) (x(1) - 1, x(1), res + 2)
        else (p2, x(1), res + 1)
      } else (p1, p2, res)
    }
    ._3
}
