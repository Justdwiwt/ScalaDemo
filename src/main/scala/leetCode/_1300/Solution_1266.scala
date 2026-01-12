package leetCode._1300

object Solution_1266 {
  def minTimeToVisitAllPoints(points: Array[Array[Int]]): Int = points
    .sliding(2)
    .collect { case Array(x, y) => (x.head - y.head).abs.max((x(1) - y(1)).abs) }
    .sum
}
