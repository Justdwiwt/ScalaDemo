package leetCode

import scala.collection.mutable

object Solution_1234 {
  def balancedString(s: String): Int = {
    val n = s.length
    val k = n / 4
    val m = mutable.Map.empty[Char, Int]
    s.foreach(n => m.update(n, m.getOrElse(n, 0) + 1))

    @scala.annotation.tailrec
    def f(l: Int, r: Int, res: Int, flag: Boolean): Int = {
      if (r >= n) res
      else {
        if (flag) m.update(s(r), m.getOrElse(s(r), 0) - 1)
        if (l < n && m.getOrElse('Q', 0) <= k && m.getOrElse('W', 0) <= k && m.getOrElse('E', 0) <= k && m.getOrElse('R', 0) <= k) {
          val t = res.min(r - l + 1)
          m.update(s(l), m.getOrElse(s(l), 0) + 1)
          f(l + 1, r, t, flag = false)
        } else f(l, r + 1, res, flag = true)
      }
    }

    f(0, 0, n, flag = true)
  }
}
