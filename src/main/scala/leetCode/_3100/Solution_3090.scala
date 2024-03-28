package leetCode._3100

import scala.collection.mutable

object Solution_3090 {
  def maximumLengthSubstring(s: String): Int = s.tails.map(str => {
    val m = mutable.Map[Char, Int]().withDefaultValue(0)
    str.takeWhile(c => {
      m(c) += 1
      m(c) <= 2
    }).length
  }).max
}
