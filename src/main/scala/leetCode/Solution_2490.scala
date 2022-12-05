package leetCode

object Solution_2490 {
  def isCircularSentence(sentence: String): Boolean = {
    sentence.indices.foreach(i => if (sentence(i) == ' ' && (sentence(i - 1) != sentence(i + 1))) return false)
    sentence.head == sentence(sentence.length - 1)
  }
}
