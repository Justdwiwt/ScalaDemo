package leetCode._300

import scala.collection.mutable

object Solution_211 {

  class WordDictionary() {

    val head = new TrieDataNode()

    def addWord(word: String) {
      head.add(word.toList)
    }

    def search(word: String): Boolean =
      head.search(word.toList).isDefined

  }

  sealed trait TrieNode

  class TrieDataNode extends TrieNode {

    private val m = mutable.Map.empty[Char, TrieNode]

    def add(list: List[Char]): Unit = list match {
      case Nil => m('\u0000') = TrieWordEndNode
      case head :: tail => m.get(head) match {
        case Some(x: TrieDataNode) => x.add(tail)
        case _ => m
          .getOrElseUpdate(head, new TrieDataNode())
          .asInstanceOf[TrieDataNode]
          .add(tail)
      }
    }

    def search(chars: List[Char]): Option[TrieNode] = chars match {
      case Nil => m.get('\u0000')
      case '.' :: tail => m
        .values
        .collect({ case x: TrieDataNode => x.search(tail) })
        .collectFirst({ case Some(TrieWordEndNode) => TrieWordEndNode })
      case head :: tail => m.get(head) match {
        case Some(x: TrieDataNode) => x.search(tail)
        case _ => None
      }
    }

  }

  object TrieWordEndNode extends TrieNode

}
