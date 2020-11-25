package leetCode

import scala.collection.mutable

object Solution_1625 {
  def findLexSmallestString(s: String, a: Int, b: Int): String = {
    var st = mutable.HashSet.empty[String]

    def f(s: String, a: Int, b: Int): Unit = {
      if (st.contains(s)) return
      else st += s
      f(g(s, a), a, b)
      f(h(s, b), a, b)
    }

    def g(s: String, a: Int): String = {
      val ch = s.toCharArray
      (1 until s.length by 2).foreach(i => ch(i) = (((s(i) - '0' + a) % 10) + '0').toChar)
      ch.mkString
    }

    def h(s: String, b: Int): String = s.substring(s.length - b) + s.substring(0, s.length - b)

    f(s, a, b)
    st.min
  }
}
