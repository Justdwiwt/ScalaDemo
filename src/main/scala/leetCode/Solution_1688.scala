package leetCode

object Solution_1688 {
  def numberOfMatches(n: Int): Int =
    if (n == 1) 0
    else if (n % 2 == 0) n / 2 + numberOfMatches(n / 2)
    else (n - 1) / 2 + numberOfMatches((n - 1) / 2 + 1)
}
