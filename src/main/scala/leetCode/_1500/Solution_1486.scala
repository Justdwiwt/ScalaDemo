package leetCode._1500

object Solution_1486 {
  def xorOperation(n: Int, start: Int): Int = {
    (0 until n).map(start + 2 * _).reduce(_ ^ _)
  }
}
