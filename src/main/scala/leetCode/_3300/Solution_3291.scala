package leetCode._3300

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.util.control.Breaks.{break, breakable}

object Solution_3291 {
  class Node {
    val next: Array[Node] = Array.fill(26)(null)
    var isEnd: Boolean = false
  }

  private class Trie {
    private val root: Node = new Node()

    def insert(word: String): Unit = {
      var cur = root
      word.foreach(ch => {
        if (cur.next(ch - 'a') == null) cur.next(ch - 'a') = new Node()
        cur = cur.next(ch - 'a')
      })
      cur.isEnd = true
    }

    def getPrefixLengths(target: String, start: Int): List[Int] = {
      val lengths = ListBuffer[Int]()
      var cur = root
      breakable {
        (start until target.length).foreach(i => {
          val ch = target(i)
          if (cur.next(ch - 'a') == null) break()
          cur = cur.next(ch - 'a')
          lengths += (i - start + 1)
        })
      }
      lengths.toList
    }
  }

  def minValidStrings(words: Array[String], target: String): Int = {
    val trie = new Trie()
    val set = mutable.HashSet(words: _*)
    set.foreach(trie.insert)

    val n = target.length
    val dp = Array.fill(n + 1)(BigInt(Int.MaxValue))
    dp(0) = 0

    target.indices.foreach(i => {
      if (dp(i) == BigInt(Int.MaxValue)) {}
      val prefixLengths = trie.getPrefixLengths(target, i)
      prefixLengths.foreach(len => dp(i + len) = dp(i + len).min(dp(i) + 1))
    })

    if (dp(n) == BigInt(Int.MaxValue)) -1 else dp(n).toInt
  }
}
