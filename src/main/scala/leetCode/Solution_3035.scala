package leetCode

object Solution_3035 {
  def maxPalindromesAfterOperations(words: Array[String]): Int = {
    val counter = words.mkString.groupBy(identity).mapValues(_.length)
    val pairs = counter.values.map(_ / 2).sum
    words.map(_.length).sorted.foldLeft(0, pairs) { case ((res, pairs), len) =>
      val newPairs = pairs - len / 2
      (if (newPairs >= 0) res + 1 else res, newPairs)
    }._1
  }
}
