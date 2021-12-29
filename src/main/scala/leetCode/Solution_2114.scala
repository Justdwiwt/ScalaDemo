package leetCode

object Solution_2114 {
  def mostWordsFound(sentences: Array[String]): Int =
    sentences.map(_.count(_ == ' ')).max + 1
}
