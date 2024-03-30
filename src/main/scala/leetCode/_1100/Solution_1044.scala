package leetCode._1100

import scala.collection.Searching.search

object Solution_1044 {
  def longestDupSubstring(s: String): String = {
    val (b, p) = (1L << 17, 8417508174513L)

    def modP(x: Long): Long =
      ((x % p) + p) % p

    def check(len: Int): Option[String] = {
      if (len == 0) Some("")
      else {
        val h0 = s.take(len).foldLeft(0L)((x, y) => modP(x * b + y))
        val fac = (1 until len).foldLeft(b)((x, _) => modP(x * b))

        val i = (0 until s.length - len)
          .iterator
          .scanLeft((h0, Set[Long]())) { case ((h, m), j) =>
            val h1 = modP(modP(h * b) - modP(fac * s(j)) + s(j + len))
            (h1, m + h)
          }
          .indexWhere { case (h, m) => m.contains(h) }

        if (i != -1) Some(s.slice(i, i + len))
        else None
      }
    }

    val help = new IndexedSeq[Int] {
      override def apply(i: Int): Int = (check(i), check(i + 1)) match {
        case (Some(_), Some(_)) => -1
        case (Some(_), None) => 0
        case _ => 1
      }

      override def length: Int = s.length
    }

    //    check(help.search(0).insertionPoint).get
    ""
  }
}
