package leetCode._200

import scala.collection.mutable

object Solution_159 {
  def lengthOfLongestSubstringTwoDistinct(s: String): Int = {
    val m = mutable.HashMap.empty[Char, Int]
    var res = 0
    var l = 0
    var r = 0
    while (r < s.length) {
      val c = s(r)
      if (!m.contains(c)) m += c -> 1
      else m += c -> (m(c) + 1)
      while (m.size > 2) {
        val chL = s(l)
        l += 1
        val v = m(chL) - 1
        if (v == 0) m.remove(chL)
        else m += chL -> v
      }
      res = res.max(r - l + 1)
      r += 1
    }
    res
  }
}
