package leetCode

object Solution_461 {
  def hammingDistance(x: Int, y: Int): Int = {
    Integer.bitCount(x ^ y)
  }
}
