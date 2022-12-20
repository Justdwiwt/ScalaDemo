package leetCode

object Solution_2506 {
  def similarPairs(words: Array[String]): Int = words
    .groupBy(_.toSet.mkString.sorted)
    .values
    .map(list => list.length * (list.length - 1) / 2)
    .sum
}
