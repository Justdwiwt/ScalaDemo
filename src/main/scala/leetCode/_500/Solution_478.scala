package leetCode._500

object Solution_478 {
  class Solution(_radius: Double, _x_center: Double, _y_center: Double) {
    val x: Double = _x_center
    val y: Double = _y_center
    val ra: Double = _radius

    def randPoint(): Array[Double] = {
      val r = math.sqrt(math.random() * ra * ra)
      val the = math.Pi * 2 * math.random()
      val rx = math.cos(the) * r + x
      val ry = math.sin(the) * r + y
      Array(rx, ry)
    }
  }
}
