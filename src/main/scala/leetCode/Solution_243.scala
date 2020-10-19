package leetCode

object Solution_243 {
  def shortestDistance(words: Array[String], word1: String, word2: String): Int = {
    var res = words.length
    words.indices.foreach(i => if (words(i).equals(word1)) words.indices.foreach(j => if (words(j).equals(word2)) res = res.min((i - j).abs)))
    res
  }
}
