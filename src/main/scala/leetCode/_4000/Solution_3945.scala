package leetCode._4000

object Solution_3945 {
  def digitFrequencyScore(n: Int): Int = n
    .abs
    .toString
    .toList
    .map(_ - '0')
    .sum
}
