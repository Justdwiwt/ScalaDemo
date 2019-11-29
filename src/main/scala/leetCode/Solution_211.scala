package leetCode

object Solution_211 {

  class WordDictionary() {

    class TrieNode {
      var flag = false
      val next: Array[TrieNode] = Array.fill(26)(null)
    }

    /** Initialize your data structure here. */

    val trieNode = new TrieNode

    /** Adds a word into the data structure. */
    def addWord(word: String) {
      val lastNode = word.foldLeft(trieNode)((node, char) => {
        val index = char - 'a'
        if (node.next(index) == null)
          node.next(index) = new TrieNode
        node.next(index)
      })
      lastNode.flag = true
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    def search(word: String): Boolean = {

      def loop(i: Int, node: TrieNode): Boolean = {
        if (node == null) false
        else if (i == word.length) node.flag
        else if (word(i) == '.') node.next.view.exists(n => n != null && loop(i + 1, n))
        else {
          val index = word(i) - 'a'
          loop(i + 1, node.next(index))
        }
      }

      loop(0, trieNode)
    }

  }

}
