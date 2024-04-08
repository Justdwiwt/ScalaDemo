package leetCode._200

object Solution_188 {
  def maxProfit(k: Int, prices: Array[Int]): Int = prices
    .foldLeft((Array.fill(k + 1)(0), Array.fill(k + 1)(Int.MinValue))) { case ((sell, buy), price) => sell
      .indices
      .tail
      .foldLeft(sell, buy) { case ((s, b), i) =>
        (s.updated(i, s(i).max(b(i) + price)), b.updated(i, b(i).max(s(i - 1) - price)))
      }
    }
    ._1
    .last
}
