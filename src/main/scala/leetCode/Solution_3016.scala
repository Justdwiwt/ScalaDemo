package leetCode

object Solution_3016 {
  def minimumPushes(word: String): Int = word
    .groupBy(identity)
    .mapValues(_.length)
    .values
    .toSeq
    .sortBy(-_)
    .grouped(8)
    .zipWithIndex
    .map { case (group, i) => group.sum * (i + 1) }
    .sum
}
