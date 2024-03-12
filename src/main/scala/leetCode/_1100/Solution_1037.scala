package leetCode._1100

object Solution_1037 {
  def isBoomerang(points: Array[Array[Int]]): Boolean = {
    val x1 = points(0)(0) - points(1)(0)
    val y1 = points(0)(1) - points(1)(1)
    val x2 = points(0)(0) - points(2)(0)
    val y2 = points(0)(1) - points(2)(1)
    x1 * y2 != x2 * y1
  }
}
