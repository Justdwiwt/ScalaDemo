package leetCode._3800

object Solution_3784 {
  def minCost(s: String, cost: Array[Int]): Long = {
    val sums =
      s.zip(cost).foldLeft(Map.empty[Char, Long]) {
        case (m, (ch, c)) =>
          m.updated(ch, m.getOrElse(ch, 0L) + c)
      }.values

    sums.sum - sums.max
  }
}
