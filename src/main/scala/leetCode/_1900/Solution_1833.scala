package leetCode._1900

object Solution_1833 {
  def maxIceCream(costs: Array[Int], coins: Int): Int = costs
    .sorted
    .foldLeft(0, 0) { case ((total, count), cost) =>
      if (total + cost > coins) (total, count)
      else (total + cost, count + 1)
    }
    ._2
}
