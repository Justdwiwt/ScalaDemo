package leetCode

object Solution_2834 {
  def minimumPossibleSum(n: Int, target: Int): Long = {
    val m = n.min(target / 2)
    ((1 + m).toLong * m / 2) + (2L * target + n - m - 1) * (n - m) / 2
  }
}
