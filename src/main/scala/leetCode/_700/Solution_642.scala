package leetCode._700

import scala.collection.mutable

object Solution_642 {
  class AutocompleteSystem(sentences: Array[String], times: Array[Int]) {

    class TrieNode extends Ordered[TrieNode] {
      val children: Array[TrieNode] = Array.ofDim[TrieNode](128)
      var s: String = _
      var times: Int = 0
      val hot: mutable.ListBuffer[TrieNode] = mutable.ListBuffer()

      def update(node: TrieNode): Unit = {
        if (!hot.contains(node)) hot += node
        val sortedHot = hot.sorted
        hot.clear()
        hot ++= sortedHot.take(3)
      }

      override def compare(that: TrieNode): Int =
        if (this.times == that.times) this.s.compareTo(that.s)
        else that.times - this.times
    }

    val root: TrieNode = new TrieNode
    var cur: TrieNode = root
    val sb: mutable.StringBuilder = new mutable.StringBuilder

    sentences.indices.foreach(i => add(sentences(i), times(i)))

    def add(sentence: String, times: Int): Unit = {
      var temp = root
      val visited = mutable.ListBuffer[TrieNode]()
      sentence.foreach(c => {
        if (temp.children(c) == null) temp.children(c) = new TrieNode
        temp = temp.children(c)
        visited += temp
      })
      temp.s = sentence
      temp.times += times
      visited.foreach(_.update(temp))
    }

    def input(c: Char): List[String] = {
      val res = mutable.ListBuffer[String]()
      if (c == '#') {
        add(sb.toString(), 1)
        sb.clear()
        cur = root
        return res.toList
      }
      sb.append(c)
      if (cur != null) cur = cur.children(c)
      if (cur == null) return res.toList
      cur.hot.foreach(res += _.s)
      res.toList
    }
  }
}
