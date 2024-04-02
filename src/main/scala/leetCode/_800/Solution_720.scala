package leetCode._800

object Solution_720 {
  def longestWord(words: Array[String]): String = {
    case class Trie(ch: Map[Char, Trie], has: Boolean)

    def add(t: Trie, s: String): Trie =
      if (s.isEmpty) t.copy(has = true)
      else {
        val next = add(t.ch.getOrElse(s.head, Trie(Map.empty, has = false)), s.tail)
        t.copy(ch = t.ch + (s.head -> next))
      }

    @scala.annotation.tailrec
    def search(t: Trie)(s: String): Boolean =
      if (s.isEmpty) true
      else if (!t.ch.contains(s.head) || !t.ch(s.head).has) false
      else search(t.ch(s.head))(s.tail)

    val trie = words.foldLeft(Trie(Map.empty, has = false))(add)
    words.sortBy(x => (-x.length, x)).find(search(trie)).getOrElse("")
  }
}
