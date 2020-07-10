package leetCode

object Solution_309 {
  def maxProfit(prices: Array[Int]): Int = {
    if (prices.isEmpty) return 0
    val hold = Array.fill(prices.length)(0)
    hold(0) -= prices(0)
    val nHold = Array.fill(prices.length)(0)
    (1 until prices.length).foreach(i => {
      if (i >= 2) hold(i) = hold(i - 1).max(nHold(i - 2) - prices(i))
      else hold(i) = hold(i - 1).max(-prices(i))
      nHold(i) = nHold(i - 1).max(hold(i - 1) + prices(i))
    })
    nHold(prices.length - 1)
  }
}
