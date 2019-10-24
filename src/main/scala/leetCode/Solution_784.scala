package leetCode

import scala.collection.mutable.ListBuffer

object Solution_784 {
  def letterCasePermutation(S: String): List[String] = {
    val res = new ListBuffer[String]
    func(S.toCharArray, 0, res)
    res.indices.foreach(i => i.toString)
    res.toList
  }

  def func(s: Array[Char], i: Int, res: ListBuffer[String]): Unit = {
    if (i == s.length) {
      res.append(s.toString)
      return
    }
    func(s, i + 1, res)
    if (isAlpha(s(i))) {
      //      s(i).toInt ^= (1 << 5)   upper <=> lower
      println(s)
      func(s, i + 1, res)
    }
  }

  def isAlpha(c: Char): Boolean = (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')
}
