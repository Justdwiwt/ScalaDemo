package leetCode._3300

object Solution_3223 {
  def minimumLength(s: String): Int = s
    .groupBy(identity)
    .mapValues(_.length)
    .values
    .map(c => (c - 1) % 2 + 1)
    .sum
}
