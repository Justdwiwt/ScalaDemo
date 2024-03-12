package leetCode._2000

object Solution_1941 {
  def areOccurrencesEqual(s: String): Boolean = s
    .groupBy(identity)
    .mapValues(_.length)
    .values
    .toSet
    .size == 1
}
