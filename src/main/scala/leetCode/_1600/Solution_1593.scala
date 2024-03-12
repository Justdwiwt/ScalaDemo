package leetCode._1600

import scala.collection.mutable

object Solution_1593 {
  def maxUniqueSplit(s: String): Int = {
    var res = 0

    def f(s: String, start: Int, cnt: Int, st: mutable.HashSet[String]): Unit = {
      if (start == s.length) {
        res = cnt.max(res)
        return
      }
      (start + 1 to s.length).foreach(i => {
        var sub = s.substring(start, i)
        if (!st.contains(sub)) {
          st += sub
          f(s, i, cnt + 1, st)
          st.remove(sub)
        } else f(s, i, cnt, st)
      })
    }

    f(s, 0, 0, mutable.HashSet.empty[String])
    res
  }
}
