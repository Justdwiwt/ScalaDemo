package leetCode._3200

object Solution_3136 {
  def isValid(word: String): Boolean = {
    val vowels = List('a', 'e', 'i', 'o', 'u') ::: List('a', 'e', 'i', 'o', 'u').map(_.toUpper)
    if (word.length >= 3 &&
      word.forall(_.isLetterOrDigit) &&
      word.exists(vowels.contains(_)) &&
      word.filter(!_.isDigit).exists(!vowels.contains(_)))
      true
    else false
  }
}
