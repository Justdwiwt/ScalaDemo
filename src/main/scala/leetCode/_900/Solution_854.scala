package leetCode._900

import scala.collection.mutable

object Solution_854 {
  def kSimilarity(s1: String, tar: String): Int = {
    val q = mutable.Queue[String](s1)
    var cnt = 0
    var res = 0
    var found = false
    while (q.nonEmpty && !found) {
      val size = q.size
      (0 until size).foreach(_ => {
        val s = q.dequeue()
        if (s == tar) found = true
        else {
          var idx = 0
          while (s(idx) == tar(idx)) idx += 1
          var j = idx
          while (j < s.length && !found) {
            if (s(j) == tar(idx) && tar(j) != s(j)) {
              val sb = new StringBuilder(s)
              sb(idx) = s(j)
              sb(j) = s(idx)
              if (sb.toString == tar) {
                found = true
                res = cnt + 1
              } else q.enqueue(sb.toString)
            }
            j += 1
          }
        }
      })
      cnt += 1
    }
    res
  }
}
