package leetCode

object Offer_63 {
  def maxProfit(prices: Array[Int]): Int = if (prices.length > 1) {
    prices.foldLeft((Int.MaxValue, 0)) { case ((minPrice, lastProfit), price) =>
      val curLowPrice = price.min(minPrice)
      val curProfit = lastProfit.max(price - minPrice)
      curLowPrice -> curProfit
    }._2
  } else 0
}
