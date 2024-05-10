package leetCode._3200

object Solution_3137 {
  def minimumOperationsToMakeKPeriodic(word: String, k: Int): Int = word
    .sliding(k, k)
    .toList
    .groupBy(identity)
    .mapValues(_.size)
    .values
    .toList
    .sorted
    .init
    .sum
}
