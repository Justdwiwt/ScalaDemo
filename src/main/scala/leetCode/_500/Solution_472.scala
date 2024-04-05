package leetCode._500

import scala.collection.mutable

object Solution_472 {
  private var nodeId = 0

  case class TrieNode(var isWord: Boolean = false, children: mutable.Map[Char, TrieNode] = mutable.Map.empty) {
    val id: Int = nodeId
    nodeId += 1
  }

  def findAllConcatenatedWordsInADict(words: Array[String]): List[String] = {
    val root = TrieNode()
    words.foreach(word => {
      var node = root
      word.foreach(char => node = node.children.getOrElseUpdate(char, TrieNode()))
      node.isWord = true
    })

    val cache = mutable.Map.empty[(String, Int, Int), Int]

    def isConcatenation(word: String, i: Int, node: TrieNode = root): Int = cache.getOrElseUpdate((word, i, node.id), {
      var restarting = if (node.id == root.id || !node.isWord) 0 else isConcatenation(word, i, root)
      val continuing =
        if (i == word.length - 1)
          if (node.children.get(word(i)).exists(_.isWord)) 1
          else 0
        else node.children.get(word(i)).map(isConcatenation(word, i + 1, _)).getOrElse(0)
      if (restarting > 0 && node.isWord) restarting += 1
      restarting.max(continuing)
    })

    words.toList.filter(isConcatenation(_, 0) > 1)
  }
}
