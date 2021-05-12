package leetCode

object Solution_1475 {
  def finalPrices(prices: Array[Int]): Array[Int] = prices
    .zipWithIndex
    .map({ case (price, i) => price - prices.drop(i + 1).find(_ <= price).getOrElse(0) })
}
