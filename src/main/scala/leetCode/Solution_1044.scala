package leetCode

object Solution_1044 {

  class Trie() {
    private val next = Array.ofDim[Trie](26)
    var size = 0

    def insert(s: String): Unit = {
      var node: Trie = this
      s.foreach(ch => {
        if (node.next(ch - 'a') == null) node.next(ch - 'a') = new Trie()
        node.size += 1
        node = node.next(ch - 'a')
      })
      node.size += 1
    }

    def findMax(): String = {
      var res = ""
      var l = this.next.zipWithIndex.zip(Array.fill(26)("")).map({ case ((trie, idx), path) => (trie, path + (idx + 'a').toChar) }).filter(_._1 != null)

      def f(node: (Trie, String)): Array[(Trie, String)] = {
        if (node._2.length > res.length) res = node._2
        node._1.next.zipWithIndex.filter({ case (trie, _) => trie != null && trie.size > 1 }).map({ case (trie, idx) => (trie, node._2 + (idx + 'a').toChar) })
      }

      while (l.exists({ case (trie, _) => trie != null && trie.size > 1 })) l = l.flatMap(f)
      res
    }
  }

  def longestDupSubstring(s: String): String = {
    val trie = new Trie()
    s.indices.foreach(i => trie.insert(s.substring(i)))
    trie.findMax()
  }

}
