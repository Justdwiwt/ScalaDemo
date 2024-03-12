package leetCode._2800

import scala.collection.mutable

object Solution_2781 {
  private final class Trie {
    private var isTerminal = false
    private val children = mutable.Map.empty[Char, Trie]

    @scala.annotation.tailrec
    def add(chars: List[Char]): Unit = chars match {
      case Nil => isTerminal = true
      case c :: tail => children.getOrElseUpdate(c, new Trie).add(tail)
    }

    def minInclude(chars: List[Char]): Option[Int] = chars match {
      case Nil => terminal
      case c :: tail => terminal.orElse(children.get(c).flatMap(_.minInclude(tail)).map(_ + 1))
    }

    private def terminal: Option[Int] =
      if (isTerminal) Some(0) else None
  }

  def longestValidSubstring(word: String, forbidden: List[String]): Int = {
    val trie = new Trie
    forbidden.foreach(string => trie.add(string.toList))
    f(word.toList, trie, 0, 0)
  }

  @scala.annotation.tailrec
  private def f(word: List[Char], trie: Trie, valid: Int, maxValid: Int): Int = word match {
    case Nil => valid.max(maxValid)
    case _ :: tail =>
      trie.minInclude(word) match {
        case None => f(tail, trie, valid + 1, maxValid)
        case Some(include) =>
          val mn = word.tails.zipWithIndex.map { case (chars, i) => trie.minInclude(chars).map(_ + i) }
          val min = mn.take(include).toList.flatten.min
          f(tail, trie, 0, maxValid.max(valid + min - 1))
      }
  }
}
