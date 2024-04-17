package leetCode._2900

object Solution_2898 {
  def maxScore(prices: Array[Int]): Long = prices
    .zipWithIndex
    .foldLeft((Map.empty[Int, Long], 0L)) { case ((sums, max), (price, i)) =>
      val diff = price - i
      val sum = sums.getOrElse(diff, 0L) + price
      val updatedSums = sums + (diff -> sum)
      (updatedSums, max.max(sum))
    }
    ._2
}
