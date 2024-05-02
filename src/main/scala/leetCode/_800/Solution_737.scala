package leetCode._800

object Solution_737 {
  def areSentencesSimilarTwo(words1: Array[String], words2: Array[String], pairs: List[List[String]]): Boolean = {
    if (words1.length != words2.length) return false

    val graph = pairs.foldLeft(Map.empty[String, List[String]].withDefaultValue(Nil)) {
      case (acc, List(p1, p2)) => acc.updated(p1, p2 :: acc(p1)).updated(p2, p1 :: acc(p2))
      case (acc, _) => acc
    }

    def dfs(word1: String, word2: String, seen: Set[String]): Boolean =
      if (word1 == word2) true
      else {
        val newSeen = seen + word1
        graph(word1).exists(nei => !newSeen.contains(nei) && dfs(nei, word2, newSeen))
      }

    words1.indices.forall(i => dfs(words1(i), words2(i), Set.empty))
  }
}
