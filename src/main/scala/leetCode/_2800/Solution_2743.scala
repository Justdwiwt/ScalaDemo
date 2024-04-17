package leetCode._2800

import scala.collection.mutable

object Solution_2743 {
  def numberOfSpecialSubstrings(s: String): Int = {
    val m = mutable.Map.empty[Char, Int].withDefaultValue(0)
    var i = -1
    var res = 0

    s.zipWithIndex.foreach { case (ch, j) =>
      if (m.contains(ch)) i = i.max(m(ch))
      m(ch) = j
      res += (j - i)
    }

    res
  }
}
