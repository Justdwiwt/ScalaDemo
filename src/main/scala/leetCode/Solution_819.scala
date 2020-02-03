package leetCode

import scala.collection.mutable

object Solution_819 {
  def mostCommonWord(paragraph: String, banned: Array[String]): String = {
    val s = new mutable.HashSet[String]()
    val m = new mutable.HashMap[String, Int]()
    banned.foreach(_ => s.add(_))
    val buffer = new StringBuffer()
    var i = 0
    while (i < paragraph.length) {
      if (!check(paragraph(i))) {
        while (i < paragraph.length && !check(paragraph(i))) i += 1
        if (i != paragraph.length) buffer.append(" ")
      } else buffer.append(paragraph(i))
      i += 1
    }
    val words = buffer.toString.split(" ")
    words.foreach(i => if (!s.contains(i.toLowerCase())) m.put(i.toLowerCase(), m.getOrElse(i.toLowerCase(), 0) + 1))
    var mx = 0
    var res = ""
    m.keySet.foreach(k =>
      if (m(k) > mx) {
        mx = m(k)
        res = k
      }
    )
    res
  }

  def check(c: Char): Boolean = (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')
}
