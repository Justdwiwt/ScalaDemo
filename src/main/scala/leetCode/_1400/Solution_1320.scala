package leetCode._1400

import scala.collection.mutable

object Solution_1320 {
  def minimumDistance(word: String): Int = {
    if (word.length <= 2) return 0
    val m = mutable.Map[Char, (Int, Int)]()
    (0 to 3).foreach(i => (0 to 5).foreach(j => m += ('A' + (i * 6) + j).toChar -> (i, j)))
    m += 'Y' -> (4, 0)
    m += 'Z' -> (4, 1)

    def cost(from: Char, to: Char): Int = {
      if (from == ' ') return 0
      (m(from)._1 - m(to)._1).abs + (m(from)._2 - m(to)._2).abs
    }

    val len = word.length
    val cache = mutable.Map[String, Int]()

    def f(idx: Int, curA: Char, curB: Char): Int = {
      if (idx == len) return 0
      val key = idx.toString + curA.toString + curB.toString
      if (cache.contains(key)) return cache(key)
      val targetChar = word.charAt(idx)
      val r = (cost(curA, targetChar) + f(idx + 1, targetChar, curB)).min(cost(curB, targetChar) + f(idx + 1, curA, targetChar))
      cache += key -> r
      r
    }

    f(0, ' ', ' ')
  }
}
