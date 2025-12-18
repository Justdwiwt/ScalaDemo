package leetCode._3700

object Solution_3652 {
  def maxProfit(prices: Array[Int], strategy: Array[Int], k: Int): Long = {
    val A = prices.zip(strategy).map { case (p, s) => p.toLong * s }.scan(0L)(_ + _)
    val B = prices.map(_.toLong).scan(0L)(_ + _)

    (k until A.length)
      .map(i => A.last - A(i) + B(i) - B(i - k / 2) + A(i - k))
      .max
      .max(A.last)
  }
}
