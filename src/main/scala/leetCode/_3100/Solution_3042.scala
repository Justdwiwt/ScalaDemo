package leetCode._3100

object Solution_3042 {
  def countPrefixSuffixPairs(words: Array[String]): Int = words
    .indices
    .map(i => (i + 1).until(words.length).count(j => isPrefixAndSuffix(words(i), words(j))))
    .sum

  private def isPrefixAndSuffix(s1: String, s2: String) =
    s2.startsWith(s1) && s2.endsWith(s1)
}
