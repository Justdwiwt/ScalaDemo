package leetCode

object Solution_3016 {
  def minimumPushes(word: String): Int = word
    .groupBy(identity)
    .mapValues(_.length)
    .values
    .toArray
    .sorted
    .reverse
    .zip(Array(1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4))
    .map(n => n._2 * n._1)
    .sum
}
