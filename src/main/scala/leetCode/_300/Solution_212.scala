package leetCode._300

import scala.collection.mutable

object Solution_212 {

  class TrieNode {
    var children = mutable.Map.empty[Char, TrieNode]
    var endsWord: Option[String] = None
  }

  class Trie {
    val root = new TrieNode()

    def add(word: String): Unit = {
      var curr = root
      word.foreach(letter => curr = curr.children.getOrElseUpdate(letter, new TrieNode()))
      curr.endsWord = Some(word)
    }
  }

  def buildTrie(words: Array[String]): Trie = {
    val trie = new Trie()
    words.foreach(word => trie.add(word))
    trie
  }

  def findWords(board: Array[Array[Char]], words: Array[String]): List[String] = {
    var st = Set.empty[String]
    val trie = buildTrie(words)

    def inBounds(coord: (Int, Int)): Boolean = coord._1 >= 0 && coord._2 >= 0 && coord._1 < board.length && coord._2 < board.head.length

    def getNeighbors(coord: (Int, Int)): List[(Int, Int)] =
      List(
        (coord._1 + 1, coord._2),
        (coord._1 - 1, coord._2),
        (coord._1, coord._2 + 1),
        (coord._1, coord._2 - 1),
      ).filter(inBounds)

    def checkMatches(node: TrieNode, coord: (Int, Int)): Unit = {
      val letter = board(coord._1)(coord._2)
      if (node.children.contains(letter)) {
        val matched = node.children(letter)
        if (matched.endsWord.nonEmpty) st += matched.endsWord.get
        board(coord._1)(coord._2) = '#'
        getNeighbors(coord).foreach(neighbor => checkMatches(matched, neighbor))
        board(coord._1)(coord._2) = letter
        if (matched.children.isEmpty) node.children -= letter
      }
    }

    board.indices.foreach(i => board.head.indices.foreach(j => checkMatches(trie.root, (i, j))))
    st.toList
  }
}
