package leetCode

import scala.util.control.Breaks._

object Solution_316 {
  def removeDuplicateLetters(s: String): String = {
    if (s == null || s.length <= 1) return s
    val m = Array.fill(26)(0)
    val arr = s.toCharArray
    arr.foreach(i => m(i - 'a') += 1)
    var p = 0
    breakable {
      s.indices.foreach(i => {
        if (s(i) < s(p)) p = i
        m(s(i) - 'a') -= 1
        if (m(s(i) - 'a') == 0) break
      })
    }
    s(p) + removeDuplicateLetters(s.substring(p + 1).replace("" + s(p), ""))
  }
}
