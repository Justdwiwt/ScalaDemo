package leetCode._200

object Solution_127 {
  private def getOptions(string: String, words: Set[String]): Set[String] = string
    .indices
    .flatMap(i => ('a' to 'z')
      .filter(_ != string(i))
      .map(c => string.substring(0, i) + c + string.substring(i + 1, string.length)))
    .filter(words.contains)
    .toSet

  @scala.annotation.tailrec
  private def path(start: Set[String], visited: Set[String], end: String, words: Set[String], count: Int): Option[Int] =
    if (start.isEmpty) None
    else if (start.contains(end)) Some(count)
    else {
      val next = start.flatMap(getOptions(_, words)) -- visited
      path(next, visited ++ start, end, words, count + 1)
    }

  def ladderLength(beginWord: String, endWord: String, wordList: List[String]): Int =
    path(Set(beginWord), Set(), endWord, wordList.toSet, 1).getOrElse(0)
}
