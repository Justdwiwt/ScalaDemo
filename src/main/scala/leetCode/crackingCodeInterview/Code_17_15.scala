package leetCode.crackingCodeInterview

object Code_17_15 {
  private class Trie {
    class Node(val c: Char) {
      val children: Array[Node] = Array.ofDim[Node](26)
      var terminal = false
    }

    private val root = new Node(' ')

    def addWord(str: String): Unit = {
      def addChar(p: Node, c: Char): Node = {
        if (p.children(c - 'a') == null) p.children(c - 'a') = new Node(c)
        p.children(c - 'a')
      }

      str.foldLeft(root)(addChar).terminal = true
    }

    private def findMatches(str: String, e: Int): List[Int] = {
      @scala.annotation.tailrec
      def loop(p: Node, s: Int, acc: List[Int]): List[Int] =
        if (s < 0 || p == null) acc
        else {
          val c = str(s)
          val child = p.children(c - 'a')
          val newAcc = if (child != null && child.terminal) s :: acc else acc
          loop(child, s - 1, newAcc)
        }

      loop(root, e, Nil)
    }

    def verify(str: String): Boolean = {
      val dp = new Array[Boolean](str.length + 1)
      dp(0) = true
      (1 to str.length).foreach(i => {
        val matches = findMatches(str, i - 1)
        val newMatches = if (i == str.length) matches.filter(_ != 0) else matches
        dp(i) = newMatches.exists(dp)
      })
      dp.last
    }
  }

  def longestWord(words: Array[String]): String = {
    val sorted = words.sortWith {
      case (w1, w2) =>
        if (w1.length == w2.length) w1 < w2
        else w1.length > w2.length
    }
    val trie = new Trie()
    sorted.foreach(word => trie.addWord(word.reverse))

    sorted.collectFirst { case word if trie.verify(word) => word }.getOrElse("")
  }
}
