package leetCode

object Solution_2427 {
  def commonFactors(a: Int, b: Int): Int =
    (1 to a.min(b)).count(i => a % i == 0 && b % i == 0)
}
