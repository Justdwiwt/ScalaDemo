package leetCode

object Solution_2894 {
  def differenceOfSums(n: Int, m: Int): Int =
    (1 + n) * n / 2 - (1 + n / m) * (n / m) * m
}
