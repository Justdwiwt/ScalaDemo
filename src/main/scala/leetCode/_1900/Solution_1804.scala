package leetCode._1900

import scala.collection.mutable

object Solution_1804 {
  class TrieNode(var isWord: Boolean = false) {
    val children: Array[TrieNode] = Array.ofDim[TrieNode](26)
    var count: Int = 0
  }

  class Trie {
    val root = new TrieNode()
    val map = mutable.HashMap.empty[String, Int]

    def insert(word: String): Unit = {
      var node = root
      word.indices.foreach(i => {
        val idx = word.charAt(i) - 'a'
        if (node.children(idx) == null) node.children(idx) = new TrieNode()
        node = node.children(idx)
        node.count += 1
      })
      node.isWord = true
      map.put(word, map.getOrElse(word, 0) + 1)
    }

    def countWordsEqualTo(word: String): Int =
      map.getOrElse(word, 0)

    def countWordsStartingWith(prefix: String): Int = {
      var node = root
      var i = 0
      while (i < prefix.length) {
        val idx = prefix(i) - 'a'
        if (node.children(idx) == null) return 0
        node = node.children(idx)
        i += 1
      }
      node.count
    }

    def erase(word: String): Unit = {
      var node: TrieNode = root
      if (map.getOrElse(word, 0) == 0) return else map.put(word, map(word) - 1)
      word.indices.foreach(i => {
        val idx = word.charAt(i) - 'a'
        if (node.children(idx) != null) node.children(idx).count -= 1
        node = node.children(idx)
      })
      node.isWord = false
    }
  }
}
