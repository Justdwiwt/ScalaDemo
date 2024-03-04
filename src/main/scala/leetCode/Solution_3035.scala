package leetCode

import scala.collection.mutable

object Solution_3035 {
  def maxPalindromesAfterOperations(words: Array[String]): Int = {
    val m = mutable.HashMap.empty[Char, Int]
    words.foreach(word => word.foreach(c => m(c) = m.getOrElse(c, 0) + 1))
    var totalPairs = m.values.map(x => x / 2).sum
    val sorted = words.map(_.length).sorted
    var res = 0
    sorted.foreach(l => {
      val neededPairs = l / 2
      if (neededPairs > totalPairs) return res
      else {
        res += 1
        totalPairs -= neededPairs
      }
    })
    res
  }
}
