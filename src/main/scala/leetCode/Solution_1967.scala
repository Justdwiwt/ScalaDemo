package leetCode

object Solution_1967 {
  def numOfStrings(patterns: Array[String], word: String): Int = patterns
    .count(word.contains(_))
}
