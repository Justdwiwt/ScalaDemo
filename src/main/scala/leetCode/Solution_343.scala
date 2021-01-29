package leetCode

object Solution_343 {
  def integerBreak(n: Int): Int =
    if (n < 4) n - 1 else math.pow(3, (n - 2) / 3).toInt * ((n - 2) % 3 + 2)
}
