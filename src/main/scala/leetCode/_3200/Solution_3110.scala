package leetCode._3200

object Solution_3110 {
  def scoreOfString(s: String): Int = s
    .map(_.toInt)
    .sliding(2)
    .map(pair => (pair.head - pair(1)).abs)
    .sum
}
