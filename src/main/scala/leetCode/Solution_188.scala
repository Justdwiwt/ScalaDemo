package leetCode

object Solution_188 {
  def maxProfit(k: Int, prices: Array[Int]): Int = {
    val sell = Array.fill(k + 1)(0)
    val buy = Array.fill(k + 1)(Int.MinValue)
    prices.foreach(price => (k to 1 by -1).foreach(i => {
      sell(i) = sell(i).max(buy(i) + price)
      buy(i) = buy(i).max(sell(i - 1) - price)
    }))
    sell.last
  }
}
