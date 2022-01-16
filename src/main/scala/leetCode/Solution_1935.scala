package leetCode

object Solution_1935 {
  def canBeTypedWords(text: String, brokenLetters: String): Int =
    text.split(" ").count(x => brokenLetters.count(x.contains(_)) == 0)
}
