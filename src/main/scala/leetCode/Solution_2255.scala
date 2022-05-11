package leetCode

object Solution_2255 {
  def countPrefixes(words: Array[String], s: String): Int =
    words.count(s.startsWith)
}
