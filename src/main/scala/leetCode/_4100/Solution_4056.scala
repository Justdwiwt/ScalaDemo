package leetCode._4100

object Solution_4056 {
  def countIntersectingIntervals(intervals: Array[Array[Int]]): Int = intervals
    .combinations(2)
    .count { case Array(a, b) => math.max(a(0), b(0)) <= math.min(a(1), b(1)) }
}
