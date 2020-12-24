package leetCode

object Solution_231 {
  def isPowerOfTwo(n: Int): Boolean = n > 0 && (n & (n - 1)) == 0
}
