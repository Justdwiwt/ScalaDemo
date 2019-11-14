package leetCode

object Solution_693 {
  def hasAlternatingBits(n: Int): Boolean = ((n + (n >> 1) + 1) & (n + (n >> 1))) == 0
}
