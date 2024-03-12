package leetCode._1800

object Solution_1720 {
  def decode(encoded: Array[Int], first: Int): Array[Int] =
    encoded.scanLeft(first)(_ ^ _)
}
