package leetCode._200

object Solution_123 {
  def maxProfit(prices: Array[Int]): Int =
    if (prices.isEmpty) 0
    else {
      val left = prices./:((List.empty[Int], prices.head)) {
        case ((acc, mn), price) =>
          val last = acc.headOption.getOrElse(0)
          val profit = last.max(price - mn)
          val newMn = mn.min(price)
          (profit :: acc, newMn)
      }._1

      val right = prices.:\((List.empty[Int], prices.last)) {
        case (price, (acc, mx)) =>
          val last = acc.headOption.getOrElse(0)
          val profit = last.max(mx - price)
          val newMx = mx.max(price)
          (profit :: acc, newMx)
      }._1.reverse

      left.zip(right).map({ case (left, right) => left + right }).max
    }
}
