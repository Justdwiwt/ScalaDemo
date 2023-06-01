package leetCode

object Solution_2706 {
  def buyChoco(prices: Array[Int], money: Int): Int = {
    val res = money - prices.sorted.take(2).sum
    if (res >= 0) res else money
  }
}
