package leetCode

object Solution_1266 {
  def minTimeToVisitAllPoints(points: Array[Array[Int]]): Int = {
    var res = 0
    (points.length - 1 to 1 by -1).foreach(i => res += Math.max(Math.abs(points(i)(0) - points(i - 1)(0)), Math.abs(points(i)(1) - points(i - 1)(1))))
    res
  }
}
