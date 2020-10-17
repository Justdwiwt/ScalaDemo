package leetCode

import scala.collection.mutable

object Solution_472 {

  class TrieNode {
    var isWord = false
    var next = new mutable.HashMap[Char, TrieNode]()

    def add(str: String): Unit = {
      var node = this
      str.indices.foreach(i => {
        if (!node.next.contains(str(i))) node.next += str(i) -> new TrieNode
        node = node.next(str(i))
      })
      node.isWord = true
    }
  }

  def findAllConcatenatedWordsInADict(words: Array[String]): List[String] = {
    val root = new TrieNode
    words.foreach(w => if (!w.equals("")) root.add(w))
    var res = List.empty[String]
    words.foreach(w => if (dfs(w.toCharArray, 0, root)) res :+= w)

    def dfs(str: Array[Char], start: Int, root: TrieNode): Boolean = {
      var node = root
      (start until str.length).foreach(i => {
        if (!node.next.contains(str(i))) return false
        node = node.next(str(i))
        if (node.isWord && dfs(str, i + 1, root)) return true
      })
      node.isWord && start != 0
    }

    res
  }
}
