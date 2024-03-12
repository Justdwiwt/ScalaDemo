package leetCode._1500

import scala.util.control.Breaks._

object Solution_1453 {
  def numPoints(points: Array[Array[Int]], r: Int): Int = {
    val M = 1e-6
    var res = 1
    points.indices.foreach(i => points.indices.foreach(j => {
      breakable {
        if (i == j || math.pow(points(i)(0) - points(j)(0), 2) + math.pow(points(j)(1) - points(j)(1), 2) > 4) break()
      }
      val dx = points(i)(0) - points(j)(0)
      val dy = points(i)(1) - points(j)(1)
      val dis = math.sqrt(dx * dx + dy * dy)
      val cs = dx / dis
      val sn = dy / dis
      val ca = dis.abs / (2 * r)
      val sa = math.sqrt(1 - ca * ca)
      val centerX = (cs * ca - sn * sa) * r + points(j)(0)
      val centerY = (cs * sa + sn * ca) * r + points(j)(1)
      var n = 0
      val k = 0
      while (k < n) {
        if (math.pow(centerX - points(k)(0), 2) + math.pow(centerY - points(k)(1), 2) < r * r + M) n += 1
        res = res.max(n)
      }
    }))
    res
  }
}
