package leetCode

object Solution_2744 {
  def maximumNumberOfStringPairs(words: Array[String]): Int = words
    .indices
    .count(i => words.indices.drop(i + 1).exists(j => words(i) == words(j).reverse))
}
