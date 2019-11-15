package leetCode

object Solution_441 {
  def arrangeCoins(n: Int): Int = {
    ((-1 + math.sqrt(1 + 8 * n.toLong)) / 2).toInt
  }
}
