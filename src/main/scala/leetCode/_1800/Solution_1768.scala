package leetCode._1800

object Solution_1768 {
  def mergeAlternately(word1: String, word2: String): String = word1
    .zipAll(word2, '_', '_')
    .flatMap { case (a, b) => (a.toString + b).filterNot(_ == '_') }
    .mkString
}
