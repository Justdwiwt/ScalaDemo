package leetCode

object Solution_1523 {
  def countOdds(low: Int, high: Int): Int = {
    ((high + 1) / 2 - (low + 1) / 2) + low % 2
  }
}
