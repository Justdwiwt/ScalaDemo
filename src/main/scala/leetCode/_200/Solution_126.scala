package leetCode._200

object Solution_126 {
  def computeDiff(f: String, s: String): Int =
    f.indices.count(i => s.charAt(i) != f.charAt(i))

  def isSimilar(f: String, s: String): Boolean =
    computeDiff(f, s) == 1

  def getSimilar(word: String, words: Set[String]): Set[String] =
    words.filter(isSimilar(word, _))

  def getSimilarIndices(word: String, words: List[String]): Set[String] =
    words.filter(isSimilar(_, word)).toSet

  @scala.annotation.tailrec
  def search(paths: List[List[String]], endWord: String, m: Map[String, Set[String]], visited: Set[String]): List[List[String]] = {
    if (paths.isEmpty) return Nil
    val (used, newPaths) = paths./:((Set.empty[String], List.empty[List[String]]))((acc, path) => {
      val candidates = m(path.last).diff(visited)
      if (candidates.contains(endWord)) {
        val finalSequence = path ++ endWord
        (Set(), acc._2 ++ finalSequence)
      }
      val newPaths = candidates.map(path ++ Seq(_))
      (acc._1 ++ candidates, acc._2 ++ newPaths)
    })
    val resultPaths = newPaths.filter(_.last.equals(endWord))
    if (resultPaths.nonEmpty) return resultPaths
    search(newPaths, endWord, m, visited ++ used)
  }

  def findLadders(beginWord: String, endWord: String, wordList: List[String]): List[List[String]] = {
    if (!wordList.contains(endWord)) return Nil
    val m = wordList.map(word => word -> getSimilarIndices(word, wordList)).toMap ++ Map(beginWord -> getSimilarIndices(beginWord, wordList))
    val paths = List(List(beginWord))
    search(paths, endWord, m, Set())
  }
}
