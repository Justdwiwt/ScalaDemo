package leetCode._2000

object Solution_1961 {
  def isPrefixString(s: String, words: Array[String]): Boolean = words
    .scanLeft(0)(_ + _.length)
    .drop(1)
    .contains(s.length) && words
    .iterator
    .flatMap(_.iterator)
    .take(s.length)
    .sameElements(s.iterator)
}
