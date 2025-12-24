package leetCode._3700

object Solution_3663 {
  def getLeastFrequentDigit(n: Int): Int = n
    .toString
    .groupBy(identity)
    .mapValues(_.length)
    .minBy { case (ch, cnt) => (cnt, ch) }
    ._1
    .asDigit
}
