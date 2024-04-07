package leetCode._300

object Solution_243 {
  def shortestDistance(words: Array[String], word1: String, word2: String): Int = {
    val indices1 = words.indices.filter(words(_) == word1)
    val indices2 = words.indices.filter(words(_) == word2)
    indices1.flatMap(i => indices2.map(j => (i - j).abs)).reduceOption(_.min(_)).getOrElse(words.length)
  }
}
