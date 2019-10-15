package leetCode

import scala.collection.mutable

object Solution_17 {
  def letterCombinations(digits: String): List[String] = {
    val res: List[String] = List[String]()
    val m: Map[Char, String] = Map[Char, String](
      '2' -> "abc",
      '3' -> "def",
      '4' -> "ghi",
      '5' -> "jkl",
      '6' -> "mno",
      '7' -> "pqrs",
      '8' -> "tuv",
      '9' -> "wxyz"
    )
    if (digits == "") return res
    var head = ""
    val q = mutable.Queue[String]()
    for (i <- 0 until m(digits(0)).length) {
      var str = ""
      str = str + i
      q.enqueue(str)
    }
    for (j <- 1 until digits.length) {
      var qSize = q.size
      while (qSize > 0) {
        for (i <- 0 until m(digits(j)).length) {
          head = q.front
          head = head + i
          q.enqueue(head)
        }
        q.dequeue()
        qSize -= 1
      }
    }
    while (q.nonEmpty) {
      res.:+(q.front)
      q.dequeue()
    }
    res
  }
}
