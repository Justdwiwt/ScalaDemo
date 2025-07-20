package leetCode._3600

object Solution_3573 {
  def maximumProfit(prices: Array[Int], k: Int): Long = {
    val INF = Long.MinValue / 2

    val init: Map[(Int, Int), Long] =
      (1 to k + 1).map(j => (j, 0) -> 0L).toMap.withDefaultValue(INF)

    def update(dp: Map[(Int, Int), Long], price: Int): Map[(Int, Int), Long] = {
      (1 to k + 1).foldLeft(dp) { case (next, j) =>
        val noStock = List(
          next((j, 0)),
          dp((j, 1)) + price,
          dp((j, 2)) - price
        ).max

        val long = dp((j, 1)).max(dp((j - 1, 0)) - price)
        val short = dp((j, 2)).max(dp((j - 1, 0)) + price)

        next.updated((j, 0), noStock)
          .updated((j, 1), long)
          .updated((j, 2), short)
      }
    }

    val finalState = prices.foldLeft(init)(update)

    finalState((k + 1, 0))
  }
}
