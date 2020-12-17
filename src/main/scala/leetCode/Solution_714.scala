package leetCode

object Solution_714 {
  def maxProfit(prices: Array[Int], fee: Int): Int = {
    val (res, _) = prices./:((0, Int.MinValue)) { case ((un, hold), price) =>
      (if ((price - fee) > 0) un.max(hold + price - fee)
      else un, hold.max(un - price))
    }
    res
  }
}
