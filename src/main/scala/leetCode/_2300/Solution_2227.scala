package leetCode._2300

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Solution_2227 {
  class Encrypter(_keys: Array[Char], _values: Array[String], _dictionary: Array[String]) {
    val keys = mutable.HashMap.empty[Char, Int]
    val values = new mutable.HashMap[String, ArrayBuffer[Int]]

    _keys.zipWithIndex.foreach { case (v, i) => keys += (v -> i) }
    _values.zipWithIndex.foreach { case (x, i) =>
      if (!values.contains(x)) values += (x -> new ArrayBuffer[Int])
      values(x) += i
    }

    case class Node(c: Char, chs: mutable.HashMap[Char, Node] = new mutable.HashMap[Char, Node], var isEnd: Boolean = false)

    def f(_node: Node, str: String): Unit = {
      var node = _node
      str.toCharArray.foreach(c => {
        if (!node.chs.contains(c)) node.chs += (c -> Node(c))
        node = node.chs(c)
      })
      node.isEnd = true
    }

    val root: Node = Node(' ')
    _dictionary.foreach(str => f(root, str))

    def encrypt(word1: String): String = word1.
      toCharArray
      .map(c => _values(keys(c)))
      .mkString

    def decrypt(word2: String): Int = {
      var cnt = 0
      var flag = true

      def f(idx: Int, node: Node): Unit = {
        if (!flag) return
        if (idx == word2.length()) {
          if (node.isEnd) cnt += 1
          return
        }

        val s = word2.charAt(idx) + "" + word2.charAt(idx + 1)

        if (!values.contains(s)) {
          flag = false
          return
        }

        values(s).foreach(id => if (node.chs.contains(_keys(id))) f(idx + 2, node.chs(_keys(id))))
      }

      f(0, root)
      cnt
    }

  }
}
