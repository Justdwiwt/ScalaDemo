package leetCode._400

object Solution_309 {
  def maxProfit(prices: Array[Int]): Int = {
    val (w, _, d) = prices./:(0, Int.MinValue, 0) { case ((w, h, d), c) => (w.max(d), h.max(w - c), h + c) }
    w.max(d)
  }
}
