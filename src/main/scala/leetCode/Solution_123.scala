package leetCode

object Solution_123 {
  def maxProfit(prices: Array[Int]): Int = {
    if (prices.isEmpty) return 0
    val g = Array.fill(3)(0)
    val l = Array.fill(3)(0)
    (0 until prices.length - 1).foreach(i => {
      val diff = prices(i + 1) - prices(i)
      (2 to 1 by -1).foreach(j => {
        l(j) = (g(j - 1) + diff.max(0)).max(l(j) + diff)
        g(j) = l(j).max(g(j))
      })
    })
    g(2)
  }
}
