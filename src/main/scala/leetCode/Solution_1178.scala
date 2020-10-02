package leetCode

import scala.collection.mutable

object Solution_1178 {
  def findNumOfValidWords(words: Array[String], puzzles: Array[String]): List[Int] = {
    class Node(_v: Char) {
      val v: Char = _v
      val children: mutable.Map[Char, Node] = mutable.Map[Char, Node]()
      var word = ""
    }

    val cntM = mutable.Map[String, Int]()
    words.foreach(w => cntM += w -> (cntM.getOrElse(w, 0) + 1))

    def f(root: Node, set: Set[Char], ch: Char): Int = {
      var cnt = 0

      def g(root: Node, set: Set[Char], ch: Char, flag: Boolean): Unit = {
        if (root.v != ' ' && !set.contains(root.v)) return
        val newFlag = if (root.v == ch) true else flag
        if (root.word.length > 0 && newFlag) cnt += cntM(root.word)
        root.children.keySet.foreach(c => g(root.children(c), set, ch, newFlag))
      }

      g(root, set, ch, flag = false)
      cnt
    }

    val root = new Node(' ')
    words.foreach(w => {
      var runner = root
      (0 until w.length).foreach(i => {
        if (!runner.children.contains(w.charAt(i))) runner.children += w.charAt(i) -> new Node(w.charAt(i))
        runner = runner.children(w(i))
        if (i == w.length - 1) runner.word = w
      })
    })
    puzzles.map({ p => f(root, p.toCharArray.toSet, p.head) }).toList
  }
}
