package leetCode

object Solution_30 {
  def findSubstring(s: String, words: Array[String]): List[Int] = {
    if (s.isEmpty || words.isEmpty) return Nil

    def toSet(w: Seq[String]): Set[(String, Int)] = w
      .groupBy(identity)
      .mapValues(_.length)
      .toSet

    val target = toSet(words)
    words.head.indices
      .flatMap(i => s.substring(i)
        .sliding(words.head.length, words.head.length)
        .sliding(words.length, 1)
        .zipWithIndex
        .map(x => x.copy(_2 = x._2 * words.head.length + i)))
      .filter(t => toSet(t._1) == target)
      .map(_._2)
      .toList
  }
}
