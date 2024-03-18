package leetCode._3100

import scala.collection.mutable

object Solution_3043 {
  private final class Trie {
    private val m = mutable.Map.empty[Char, Trie]

    @scala.annotation.tailrec
    def add(chars: List[Char]): Unit = chars match {
      case c :: tail => m.getOrElseUpdate(c, new Trie).add(tail)
      case Nil =>
    }

    def size(chars: List[Char]): Int = chars match {
      case c :: tail => m.get(c).fold(0)(_.size(tail) + 1)
      case Nil => 0
    }
  }

  def longestCommonPrefix(arr1: Array[Int], arr2: Array[Int]): Int = {
    val trie = new Trie
    arr2.foreach(i => trie.add(i.toString.toList))
    arr1.map(i => trie.size(i.toString.toList)).max
  }
}
