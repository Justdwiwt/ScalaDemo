package leetCode

object Solution_520 {
  def detectCapitalUse(word: String): Boolean = {
    if (word == word.toUpperCase || word == word.toLowerCase || word.head == word.toUpperCase.head && word.tail == word.tail.toLowerCase) true
    else false
  }
}
