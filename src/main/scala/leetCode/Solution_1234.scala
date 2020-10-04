package leetCode

import scala.collection.mutable

object Solution_1234 {
  def balancedString(str: String): Int = {
    if (str == null || str.length == 0 || str.length % 4 != 0) return Integer.MAX_VALUE
    var q, e, w, r = 0
    str.toCharArray.foreach(c => {
      if (c == 'Q') q += 1
      if (c == 'W') w += 1
      if (c == 'E') e += 1
      if (c == 'R') r += 1
    })
    val quater = str.length / 4

    def greater(m1: mutable.Map[Char, Int], m0: mutable.Map[Char, Int]): Boolean = {
      if (m1.size != m0.size) return false
      var res = true
      m1.keySet.foreach(k => if (!m0.contains(k) || m1(k) < m0(k)) res = false)
      res
    }

    val bm, m = mutable.Map[Char, Int]()
    if (q > quater) bm += 'Q' -> (q - quater)
    if (e > quater) bm += 'E' -> (e - quater)
    if (w > quater) bm += 'W' -> (w - quater)
    if (r > quater) bm += 'R' -> (r - quater)
    if (bm.isEmpty) return 0
    var mnLen = str.length
    var left = 0
    var right = 0
    while (left < str.length && right < str.length) {
      val curr = str.charAt(right)
      if (bm.contains(curr)) {
        m += curr -> (m.getOrElse(curr, 0) + 1)
        while (greater(m, bm) && left <= right) {
          mnLen = mnLen.min(right - left + 1)
          val leftChar = str.charAt(left)
          if (bm.contains(leftChar)) m += leftChar -> (m(leftChar) - 1)
          left += 1
        }
      }
      right += 1
    }
    mnLen
  }
}
