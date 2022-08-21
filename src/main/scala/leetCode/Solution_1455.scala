package leetCode

object Solution_1455 {
  def isPrefixOfWord(sentence: String, searchWord: String): Int = sentence
    .split(' ')
    .iterator
    .zipWithIndex
    .find(_._1.startsWith(searchWord))
    .map(_._2 + 1)
    .getOrElse(-1)
}
