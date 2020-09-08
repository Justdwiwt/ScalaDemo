package leetCode

import scala.collection.mutable

object Solution_522 {
  def isSubSeq(a: String, b: String): Boolean = {
    var i = 0
    var j = 0
    while (i < a.length) {
      val t = b.indexOf(a(i), j)
      if (t == -1) return false
      j = 1 + t
      i += 1
    }
    true
  }

  def findLUSlength(strs: Array[String]): Int = {
    val m = mutable.Map[String, Int]().withDefaultValue(0)
    val s = mutable.Set[String]("")
    strs.foreach(str => {
      m(str) += 1
      if (m(str) > 1) s += str
    })
    m.keySet.diff(s.toSet).toList.sortWith(_.length > _.length).foreach(str => {
      if (s.forall(!isSubSeq(str, _))) return str.length
      s += str
    })
    -1
  }
}
