package leetCode._1400

object Solution_1374 {
  def generateTheString(n: Int): String = n % 2 match {
    case 0 => "a" * (n - 1) + "b"
    case 1 => "a" * n
  }
}
