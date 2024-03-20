package leetCode._2100

object Solution_2068 {
  def checkAlmostEquivalent(word1: String, word2: String): Boolean = !(word1
    .groupBy(identity)
    .mapValues(-_.length)
    .toList ++ word2
    .groupBy(identity)
    .mapValues(_.length)
    .toList)
    .groupBy(_._1)
    .map { case (k, v) => k -> v.map(_._2).sum }
    .exists(_._2.abs > 3)
}
