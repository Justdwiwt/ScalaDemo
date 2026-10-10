package leetCode._4100

object Solution_4014 {
  def minPrice(prices: Array[Int], discounts: Array[Int]): Double = {
    val ps = prices.sorted.reverse
    val ds = discounts.sorted.reverse

    (ps.map(_.toLong).sum * 100 - ps.zip(ds).map { case (p, d) => p.toLong * d }.sum) / 100.0
  }
}
