package leetCode

object Solution_231 {
  def isPowerOfTwo(n: Int): Boolean = {
    if (n <= 0) return false
    (n & (n - 1)) == 0
  }
}
