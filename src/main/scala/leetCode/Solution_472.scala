package leetCode

import scala.collection.mutable
import scala.math.Ordering._

object Solution_472 {
  class TrieNode {
    var isWord: Boolean = false
    val child = mutable.HashMap.empty[Char, TrieNode]

    override def toString: String = {
      isWord.toString + " " + child.toString
    }
  }

  object LenghtOrdering extends StringOrdering {
    override def compare(x: String, y: String): Int = {
      x.length.compare(y.length)
    }
  }

  private var root: TrieNode = _

  def add(word: String): Unit = {
    var tmp = root
    word.foreach(ch => {
      if (!tmp.child.contains(ch)) {
        val newNode = new TrieNode
        tmp.child(ch) = newNode
      }
      tmp = tmp.child(ch)
    })
    tmp.isWord = true
  }

  def doesExists(word: String, root: TrieNode, index: Int): Boolean = {
    var temp = root
    (index until word.length).foreach(i => {
      val ch = word(i)
      if (!temp.child.contains(ch)) return false
      if (temp.child(ch).isWord) {
        if (i == word.length - 1) return true
        if (doesExists(word, root, i + 1)) return true
      }
      temp = temp.child(ch)
    })
    false
  }

  def findAllConcatenatedWordsInADict(words: Array[String]): List[String] = {
    root = new TrieNode
    val sortedWords = words.sorted(LenghtOrdering)
    val res = mutable.ListBuffer.empty[String]
    sortedWords.foreach(word => {
      if (doesExists(word, root, 0)) res.append(word)
      else add(word)
    })
    res.toList

  }
}
