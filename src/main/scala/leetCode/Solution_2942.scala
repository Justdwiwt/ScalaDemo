package leetCode

object Solution_2942 {
  def findWordsContaining(words: Array[String], x: Char): List[Int] = words
    .zipWithIndex
    .filter(_._1.contains(x))
    .map(_._2)
    .toList
}
