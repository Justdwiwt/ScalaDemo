package leetCode.crackingCodeInterview

object Code_16_03 {
  private val E = 1e-6

  def intersection(start1: Array[Int], end1: Array[Int], start2: Array[Int], end2: Array[Int]): Array[Double] = {
    val x1 = start1(0)
    val y1 = start1(1)
    val x2 = end1(0)
    val y2 = end1(1)
    val x3 = start2(0)
    val y3 = start2(1)
    val x4 = end2(0)
    val y4 = end2(1)
    val a11 = y2 - y1
    val a12 = x1 - x2
    val b1 = x1 * y2 - x2 * y1
    val a21 = y4 - y3
    val a22 = x3 - x4
    val b2 = x3 * y4 - x4 * y3
    val D = a11 * a22 - a12 * a21
    val D1 = b1 * a22 - a12 * b2
    val D2 = a11 * b2 - b1 * a21

    if (D == 0 && D1 == 0) {
      if (x3.min(x4) > x1.max(x2) || x1.min(x2) > x3.max(x4)) return Array.empty
      if (y3.min(y4) > y1.max(y2) || y1.min(y2) > y3.max(y4)) return Array.empty
      val diff = Array(Array(x1, y1), Array(x2, y2), Array(x3, y3), Array(x4, y4))
      val t = diff.sortBy(x => (x(0), x(1)))
      return Array(t(1)(0).toDouble, t(1)(1).toDouble)
    }

    if (D != 0) {
      val x0 = D1 / D.toDouble
      val y0 = D2 / D.toDouble
      if (inLine(x0, x1, x2) && (inLine(x0, x3, x4) && inLine(y0, y1, y2) && inLine(y0, y3, y4))) return Array(x0, y0)
    }
    Array.empty
  }

  def inLine(x: Double, s: Double, e: Double): Boolean = {
    if ((x - s).abs < E || (x - e).abs < E) return true
    (x - s > 0 && e - x > 0) || (x - e > 0 && s - x > 0)
  }
}
