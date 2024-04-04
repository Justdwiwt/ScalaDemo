package leetCode._1500

object Solution_1453 {
  private def getDistance(x1: Double, x2: Double, y1: Double, y2: Double): Double =
    (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)

  def numPoints(points: Array[Array[Int]], r: Int): Int = {
    if (points.length < 2) return points.length
    var res = 1
    var d, x, y, centerX, centerY, h, x1, x2, y1, y2 = 0.0

    points.indices.foreach(i => points.indices.foreach(j =>
      if (i == j) {}
      else {
        x1 = points(i)(0)
        y1 = points(i)(1)
        x2 = points(j)(0)
        y2 = points(j)(1)
        d = math.sqrt(getDistance(x1, x2, y1, y2))
        if (d > 2 * r) {}
        else {
          x = (x1 + x2) / 2
          y = (y1 + y2) / 2
          if (x1 == x2) {
            centerX = x
            centerY = y
          } else {
            h = math.sqrt(r * r - (d / 2) * (d / 2))
            centerX = h * (y2 - y1) / d + x
            centerY = -h * (x2 - x1) / d + y
          }
        }
        var cnt = 0
        points.indices.foreach(k => if (getDistance(points(k)(0), centerX, points(k)(1), centerY) - r * r <= 0.00001) cnt += 1)
        res = cnt.max(res)
      }))
    res
  }
}
