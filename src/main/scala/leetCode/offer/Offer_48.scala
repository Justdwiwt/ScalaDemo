package leetCode.offer

import scala.collection.mutable

object Offer_48 {
  def lengthOfLongestSubstring(s: String): Int = {
    val m = new mutable.HashMap[Char, Int]()
    var res = 0
    var r = 0
    var l = 0
    while (r < s.length) {
      if (m.contains(s(r))) l = (m(s(r)) + 1).max(l)
      res = res.max(r - l + 1)
      m.put(s(r), r)
      r += 1
    }
    res
  }
}
