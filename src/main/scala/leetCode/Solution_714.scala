package leetCode

object Solution_714 {
  def maxProfit(prices: Array[Int], fee: Int): Int = {
    var res = 0
    var v = -prices(0)
    prices.foreach(i => {
      val t = res
      res = res.max(v + i - fee)
      v = v.max(t - i)
    })
    res
  }
}
