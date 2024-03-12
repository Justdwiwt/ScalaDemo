package leetCode._1300

import scala.collection.mutable

object Solution_1297 {
  def maxFreq(s: String, maxLetters: Int, minSize: Int, maxSize: Int): Int = {

    def check(s: String, mxLetter: Int): Boolean = {
      val m = new mutable.HashMap[Char, Int]()
      s.toCharArray.foreach(i => {
        m.put(i, m.getOrElse(i, 0) + 1)
        if (m.size > mxLetter) return false
      })
      true
    }

    var mx = 0
    val m = new mutable.HashMap[String, Int]()
    (0 to s.length - minSize).foreach(i => {
      val t = s.substring(i, i + minSize)
      m.put(t, m.getOrElse(t, 0) + 1)
    })
    m.keySet.foreach(i => if (m(i) > mx && check(i, maxLetters)) mx = m(i))
    mx
  }
}
