package leetCode._3500

import scala.collection.mutable

object Solution_3412 {
  def calculateScore(s: String): Long = {
    val st = Array.fill(26)(mutable.Stack[Int]())
    var res = 0L
    s.zipWithIndex.foreach { case (c, i) =>
      val ch = c - 'a'
      if (st(25 - ch).nonEmpty) res += i - st(25 - ch).pop()
      else st(ch).push(i)
    }
    res
  }
}
