package leetCode

object Solution_2108 {
  def firstPalindrome(words: Array[String]): String = words
    .find(w => w == w.reverse)
    .getOrElse("")
}
