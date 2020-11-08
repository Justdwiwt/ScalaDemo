package leetCode

object Solution_122 {
  def maxProfit(prices: Array[Int]): Int = {
    if (prices.isEmpty) 0
    else (0 until prices.length - 1)./:(0)((profit, i) => {
      if (prices(i) < prices(i + 1)) profit + prices(i + 1) - prices(i) else profit
    })
  }
}
