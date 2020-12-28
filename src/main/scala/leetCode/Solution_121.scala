package leetCode

object Solution_121 {
  def maxProfit(prices: Array[Int]): Int = prices./:((Int.MaxValue, 0)) { (t, n) => (t._1.min(n), t._2.max(n - t._1)) }._2
}
