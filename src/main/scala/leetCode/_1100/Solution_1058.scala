package leetCode._1100

object Solution_1058 {
  def minimizeError(prices: Array[String], target: Int): String = {
    val A = prices.map(_.toDouble)
    val C = A.map(_.toInt)
    val B = A.zip(C).map { case (x, y) => x - y }.filterNot(_ == 0).sortBy(-_)
    if (C.sum > target || C.sum + B.length < target) "-1"
    else "%.3f".format(B.slice(0, target - C.sum).map(1 - _).sum + B.slice(target - C.sum, B.length).sum)
  }
}
