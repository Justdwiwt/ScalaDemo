package leetCode

import scala.collection.mutable

object Solution_1898 {
  def maximumRemovals(s: String, p: String, remo: Array[Int]): Int = {
    val st = mutable.HashSet.empty[Int]
    var last = -1
    var start = 0
    var end = remo.length - 1
    var mx = 0
    while (start <= end) {
      val mid = (end + start) >> 1
      if (last < mid) (last + 1 to mid).foreach(st add remo(_))
      else (last to mid + 1 by -1).foreach(st remove remo(_))
      last = mid
      if ( {
        var i, j = 0
        while (i < s.length && j < p.length) {
          if (s.charAt(i) == p.charAt(j) && !st.contains(i)) j += 1
          i += 1
        }
        j == p.length
      }) {
        mx = mx.max(mid + 1)
        start = mid + 1
      }
      else end = mid - 1
    }
    mx
  }
}
