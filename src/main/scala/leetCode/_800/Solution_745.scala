package leetCode._800

import scala.collection.mutable

object Solution_745 {
  class WordFilter(_words: Array[String]) {
    class TrieNode {
      val children = mutable.HashMap.empty[Char, TrieNode]
      var wordIdx: Int = -1
    }

    def buildTrie(charList: List[Char], curNode: TrieNode, wordIndex: Int): TrieNode = charList match {
      case Nil =>
        curNode.wordIdx = wordIndex
        curNode
      case c :: tail =>
        curNode.wordIdx = wordIndex
        if (!curNode.children.contains(c)) curNode.children += ((c, new TrieNode()))
        buildTrie(tail, curNode.children(c), wordIndex)
    }

    def shiftList(charList: List[Char], i: Int): List[Char] =
      charList.drop(charList.length - i) ++ List('#') ++ charList

    lazy val root: TrieNode = {
      val root = new TrieNode()
      _words.zipWithIndex.foreach(pair => {
        val (word, i) = pair
        val wordList = word.toList
        (1 to wordList.length).foreach(j => buildTrie(shiftList(wordList, j), root, i))
      })
      root
    }

    def f(prefix: String, suffix: String): Int = {
      @scala.annotation.tailrec
      def search(charList: List[Char], curNode: TrieNode): Int = charList match {
        case Nil => curNode.wordIdx
        case c :: tail => if (curNode.children.contains(c)) search(tail, curNode.children(c)) else -1
      }

      search((suffix + "#" + prefix).toList, root)
    }
  }
}
