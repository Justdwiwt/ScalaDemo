package leetCode

object Solution_1897 {
  def makeEqual(words: Array[String]): Boolean = words
    .toList
    .flatMap(_.toList)
    .groupBy(x => x)
    .mapValues(_.size)
    .values
    .forall(x => x % words.length == 0)
}
