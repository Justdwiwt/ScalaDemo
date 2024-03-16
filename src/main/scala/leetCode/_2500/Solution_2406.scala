package leetCode._2500

object Solution_2406 {
  def minGroups(intervals: Array[Array[Int]]): Int = intervals
    .flatMap { case Array(start, end) => Array((start, 1), (end + 1, -1)) }
    .sorted
    .foldLeft(0, 0) { case ((pre, mx), (_, balance)) => (pre + balance, mx.max(pre + balance)) }
    ._2
}
