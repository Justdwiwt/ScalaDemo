package leetCode._3600

object Solution_3545 {
  def minDeletion(s: String, k: Int): Int = s
    .groupBy(identity)
    .mapValues(_.length)
    .values
    .toList
    .sorted
    .dropRight(k)
    .reduceOption(_ + _)
    .getOrElse(0)
}
