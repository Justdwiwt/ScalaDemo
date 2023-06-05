package leetCode

import scala.collection.mutable

object Solution_2707 {
  def minExtraChar(s: String, dictionary: Array[String]): Int = {
    val m = mutable.HashMap.empty[Int, Int]

    def f(s: String, ds: Set[String], idx: Int): Int = {
      if (idx >= s.length) return 0
      if (m.contains(idx)) return m.getOrElse(idx, -1)
      val res = (1 to s.length - idx)./:(1 + f(s, ds, idx + 1))((res, i) => {
        if (ds.contains(s.substring(idx, i + idx))) res.min(f(s, ds, idx + i)) else res
      })
      m += (idx -> res)
      res
    }

    f(s, dictionary.toSet, 0)
  }
}
