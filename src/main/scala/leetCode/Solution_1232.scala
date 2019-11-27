package leetCode

object Solution_1232 {
  def checkStraightLine(coordinates: Array[Array[Int]]): Boolean = {
    val y1 = coordinates(1)(1) - coordinates(0)(1)
    val x1 = coordinates(1)(0) - coordinates(0)(0)
    (0 until coordinates.length - 1).foreach(i => {
      val y2 = coordinates(i)(1) - coordinates(0)(1)
      val x2 = coordinates(i)(0) - coordinates(0)(0)
      if (y2 * x1 != y1 * x2) return false
    })
    true
  }
}
