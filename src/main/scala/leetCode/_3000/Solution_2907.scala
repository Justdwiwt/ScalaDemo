package leetCode._3000

object Solution_2907 {
  def maxProfit(prices: Array[Int], profits: Array[Int]): Int = prices
    .indices
    .drop(1)
    .dropRight(1)
    .foldLeft(-1)((mx, j) => {
      val pi = (0 until j).filter(prices(_) < prices(j)).map(profits(_)).foldLeft(-1)(_.max(_))
      val pk = (j + 1 until prices.length).filter(prices(j) < prices(_)).map(profits(_)).foldLeft(-1)(_.max(_))
      if (pi > -1 && pk > -1) mx.max(pi + pk + profits(j)) else mx
    })
}
