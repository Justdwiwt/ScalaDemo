package leetCode._3900

object Solution_3870 {
  def countCommas(n: Int): Int =
    if (n < 1000) 0 else n - 1000 + 1
}
