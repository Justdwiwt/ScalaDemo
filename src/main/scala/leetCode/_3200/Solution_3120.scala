package leetCode._3200

object Solution_3120 {
  def numberOfSpecialChars(word: String): Int =
    word.distinct.count(c => c.isLower && word.contains(c.toUpper))
}
