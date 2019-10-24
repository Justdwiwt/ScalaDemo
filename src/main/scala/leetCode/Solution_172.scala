package leetCode

object Solution_172 {
  def trailingZeroes(n: Int): Int = {
    if (n / 5 < 5) n / 5 else n / 5 + trailingZeroes(n / 5)
  }
}
