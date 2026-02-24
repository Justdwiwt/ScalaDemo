package leetCode._3900

object Solution_3839 {
  def prefixConnected(words: Array[String], k: Int): Int = words
    .collect { case v if v.length >= k => v.substring(0, k) }
    .groupBy(identity)
    .toList
    .count(_._2.length > 1)
}
