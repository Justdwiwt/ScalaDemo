package leetCode

object Solution_188 {
  def maxProfit(k: Int, prices: Array[Int]): Int = {
    if (prices.isEmpty) return 0
    if (k > prices.length) return func(prices)
    val g = Array.fill(k + 1)(0)
    val l = Array.fill(k + 1)(0)
    (0 until prices.length - 1).foreach(i => {
      val tmp = prices(i + 1) - prices(i)
      (k to 1 by -1).foreach(j => {
        l(j) = (g(j - 1) + tmp.max(0)).max(l(j) + tmp)
        g(j) = g(j).max(l(j))
      })
    })
    g(k)
  }

  def func(prices: Array[Int]): Int = {
    var res = 0
    (1 until prices.length).foreach(i => if (prices(i) - prices(i - 1) > 0) res += prices(i) - prices(i - 1))
    res
  }
}
