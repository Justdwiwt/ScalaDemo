package leetCode

object Solution_1401 {
  def checkOverlap(radius: Int, x_center: Int, y_center: Int, x1: Int, y1: Int, x2: Int, y2: Int): Boolean = {
    val x0 = (x1 + x2) / 2.0
    val y0 = (y1 + y2) / 2.0
    val p = Array((x_center - x0).abs, (y_center - y0).abs)
    val q = Array(x2 - x0, y2 - y0)
    val u = Array((p(0) - q(0)).max(0.0), (p(1) - q(1)).max(0.0))
    math.sqrt(u(0) * u(0) + u(1) * u(1)) <= radius
  }
}
