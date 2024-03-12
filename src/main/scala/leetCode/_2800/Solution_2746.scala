package leetCode._2800

import scala.collection.mutable

object Solution_2746 {
  def minimizeConcatenatedLength(words: Array[String]): Int = {
    val m = mutable.Map.empty[(Int, Char, Char), Int]

    def f(i: Int, head: Char, last: Char): Int = m.getOrElseUpdate((i, head, last),
      if (i == words.length) 0
      else {
        val n = words(i).length
        val appendCost = if (words(i).head == last) n - 1 else n
        val prependCost = if (words(i).last == head) n - 1 else n
        (appendCost + f(i + 1, head, words(i).last)).min(prependCost + f(i + 1, words(i).head, last))
      }
    )

    val head = words.head
    head.length + f(1, head.head, head.last)
  }
}
