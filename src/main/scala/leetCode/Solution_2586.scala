package leetCode

object Solution_2586 {
  def vowelStrings(words: Array[String], left: Int, right: Int): Int = words
    .slice(left, left + right - left + 1)
    .count(n => "aeiou".contains(n.head) & "aeiou".contains(n.last))
}
