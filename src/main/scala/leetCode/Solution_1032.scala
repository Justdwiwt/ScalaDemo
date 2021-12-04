package leetCode

object Solution_1032 {
  class StreamChecker(_words: Array[String]) {
    val root: Trie = Trie.build(_words)
    val maxLength: Int = _words.map(_.length).max
    var stream = List.empty[Char]

    def query(letter: Char): Boolean = {
      stream = (letter :: stream).take(maxLength)
      check(root, stream)
    }

    def check(trie: Trie, currentStream: List[Char]): Boolean = {
      if (trie.isWord) true
      else if (currentStream.isEmpty) false
      else {
        val c = currentStream.head
        if (trie.children.contains(c)) {
          val child = trie.children(c)
          check(child, currentStream.tail)
        }
        else false
      }
    }
  }

  case class Trie(children: Map[Char, Trie], isWord: Boolean = false)

  object Trie {
    def build(words: Array[String]): Trie = {
      val root: Trie = Trie(Map.empty)
      words./:(root) { case (updatedTrie, word) =>
        build(updatedTrie, word.reverse)
      }
    }

    def build(trie: Trie, word: String): Trie = {
      if (word.isEmpty) trie.copy(isWord = true)
      else {
        val c = word.head
        val updatedChild = if (trie.children.contains(c)) trie.children(c)
        else Trie(Map.empty)
        val t: Trie = build(updatedChild, word.tail)
        trie.copy(children = trie.children + (c -> t))
      }
    }
  }
}
