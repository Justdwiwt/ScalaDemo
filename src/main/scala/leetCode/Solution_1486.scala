package leetCode

object Solution_1486 {
  def xorOperation(n: Int, start: Int): Int = {
    (0 until n).map(start + 2 * _).reduce((a, b) => a ^ b)
  }
}
