package leetCode._1900

object Solution_1897 {
  def makeEqual(words: Array[String]): Boolean = words
    .toList
    .flatMap(_.toList)
    .groupBy(x => x)
    .mapValues(_.size)
    .values
    .forall(_ % words.length == 0)
}
