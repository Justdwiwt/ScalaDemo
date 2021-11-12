package leetCode

object Solution_2063 {
  def countVowels(word: String): Long = word
    .indices
    .filter(i => "aeiou".contains(word(i)))
    .map(i => (i + 1L) * (word.length - i))
    .sum
}
