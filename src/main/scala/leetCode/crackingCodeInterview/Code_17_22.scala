package leetCode.crackingCodeInterview

import scala.collection.mutable

object Code_17_22 {
  var res: List[String] = Nil
  var memo = mutable.Set.empty[String]

  def findLadders(beginWord: String, endWord: String, wordList: List[String]): List[String] = {
    res = List.empty[String]
    memo.clear()
    val st = wordList.filter(_.length == endWord.length).toSet
    if (beginWord == endWord) List(beginWord)
    else if (!st(endWord)) List.empty[String]
    else {
      f(endWord, beginWord, st - beginWord, List(beginWord))
      res
    }
  }

  private def f(endWord: String, cur: String, set: Set[String], path: List[String]): Unit =
    if (res == Nil && !memo(cur)) {
      if (cur == endWord) res = path
      else {
        set.foreach(word => if (word.zip(cur).count { case (c1, c2) => c1 != c2 } == 1) f(endWord, word, set - word, path :+ word))
        if (res == Nil) memo += cur
      }
    }
}
