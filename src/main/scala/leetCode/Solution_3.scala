package leetCode

import scala.collection.mutable

object Solution_3 {
  def lengthOfLongestSubstring(s: String): Int = {
    var res = 0
    var pLeft = 0
    var pRight = 0
    val size = s.length
    val map = mutable.HashMap[Char, Int]()
    while (pRight < size) {
      val c = s(pRight)
      if (map.contains(c)) {
        val index = map(c)
        res = res.max(pRight - pLeft)
        while (pLeft <= index) {
          map -= s(pLeft)
          pLeft += 1
        }
      }
      map.put(c, pRight)
      pRight += 1
    }
    res.max(map.size)
  }
}
