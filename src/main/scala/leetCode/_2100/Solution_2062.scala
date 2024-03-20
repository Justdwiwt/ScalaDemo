package leetCode._2100

object Solution_2062 {
  def countVowelSubstrings(word: String): Int = word
    .indices
    .flatMap(a => (a + 1 to word.length)
      .withFilter(word.substring(a, _).toSet == "aeiou".toSet)
      .map(_ => 1))
    .sum
}
