package leetCode

object Solution_812 {
  def largestTriangleArea(points: Array[Array[Int]]): Double = {
    var res = 0.0
    points.foreach(i => points.foreach(j => points.foreach(k => res = res.max(0.5 * math.abs(i(0) * j(1) + j(0) * k(1) + k(0) * i(1) - j(0) * i(1) - k(0) * j(1) - i(0) * k(1))))))
    res
  }
}
