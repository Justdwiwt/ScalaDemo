package leetCode

object Solution_2185 {
  def prefixCount(words: Array[String], pref: String): Int =
    words.count(_.startsWith(pref))
}
