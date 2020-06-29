package leetCode

import scala.collection.mutable

object Solution_1461 {
  def hasAllCodes(s: String, k: Int): Boolean = {
    var l = 0
    var r = k
    val st = new mutable.HashSet[String]()
    while (r <= s.length) {
      st.add(s.substring(l, r))
      l += 1
      r += 1
    }
    if (st.size == math.pow(2, k)) return true
    false
  }
}
