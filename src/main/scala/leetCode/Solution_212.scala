package leetCode

import scala.collection.mutable.ListBuffer

object Solution_212 {

  class TrieNode {
    var str = ""
    var child: Array[TrieNode] = Array.fill(26)(null)
  }

  class Trie {
    var root = new TrieNode()

    def insert(s: String): Unit = {
      var p = root
      s.foreach(c => {
        val t = c - 'a'
        if (p.child(t) == null) p.child(t) = new TrieNode()
        p = p.child(t)
      })
      p.str = s
    }
  }

  def findWords(board: Array[Array[Char]], words: Array[String]): List[String] = {
    val res = ListBuffer[String]()
    if (words.isEmpty || board.isEmpty || board(0).isEmpty) return res.toList
    val flag = Array.fill(board.length, board(0).length)(false)
    val T = new Trie()
    words.foreach(i => T.insert(i))
    board.indices.foreach(i => board(i).indices.foreach(j =>
      if (T.root.child(board(i)(j) - 'a') != null)
        search(board, T.root.child(board(i)(j) - 'a'), i, j, flag, res)
    ))
    res.toList
  }

  def search(board: Array[Array[Char]], p: TrieNode, i: Int, j: Int, flag: Array[Array[Boolean]], res: ListBuffer[String]): Unit = {
    if (p.str.nonEmpty) {
      res.append(p.str)
      p.str = ""
    }
    val diff = Array(Array(-1, 0), Array(1, 0), Array(0, 1), Array(0, -1))
    flag(i)(j) = true
    diff.foreach(v => {
      val nx = v(0) + i
      val ny = v(1) + j
      if (nx >= 0 && nx < board.length && ny >= 0 && ny < board(0).length && !flag(nx)(ny) && p.child(board(nx)(ny) - 'a') != null)
        search(board, p.child(board(nx)(ny) - 'a'), nx, ny, flag, res)
    })
    flag(i)(j) = true
  }
}
