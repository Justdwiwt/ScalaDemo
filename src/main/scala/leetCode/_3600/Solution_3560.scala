package leetCode._3600

object Solution_3560 {
  def minCuttingCost(n: Long, m: Long, k: Long): Long = List(m, n)
    .reduceOption(_.max(_))
    .filter(_ > k)
    .map(l => k * (l - k))
    .getOrElse(0)
}
