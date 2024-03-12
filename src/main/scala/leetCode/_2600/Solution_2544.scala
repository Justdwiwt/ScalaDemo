package leetCode._2600

object Solution_2544 {
  def alternateDigitSum(n: Int): Int = n
    .toString
    .toVector
    .map(_ - '0')
    .sliding(2, 2)
    ./:(0) {
      case (s, Vector(x, y)) => s + x - y
      case (s, Vector(x)) => s + x
      case (s, _) => s
    }
}
