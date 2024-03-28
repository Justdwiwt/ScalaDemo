package leetCode._1300

object Solution_1207 {
  def uniqueOccurrences(arr: Array[Int]): Boolean = !arr
    .groupBy(identity)
    .mapValues(_.length)
    .values
    .groupBy(identity)
    .mapValues(_.size)
    .exists(_._2 > 1)
}
