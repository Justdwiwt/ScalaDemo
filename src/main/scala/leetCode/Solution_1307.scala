package leetCode

import scala.collection.mutable

object Solution_1307 {
  def isSolvable(words: Array[String], result: String): Boolean = {
    if (words.length == 1) return words(0).equals(result)
    val m = new mutable.HashMap[Char, Int]()
    val st = new mutable.HashSet[Char]
    words.foreach(x => {
      st += x.head
      x.toCharArray.foreach(m += _ -> -1)
    })
    st += result.head
    result.toCharArray.foreach(m += _ -> -1)
    if (m.size > 10) return false
    val chars = new mutable.ArrayBuffer[Char]()
    m.keySet.foreach(chars.append(_))
    val used = new mutable.HashSet[Int]()

    def g(str: String): Int = {
      var s = ""
      str.toCharArray.map(m.get).foreach(s += _)
      s.toInt
    }

    def f(idx: Int): Boolean = {
      if (idx == chars.size) return words.map(g).sum == g(result)
      val curr = chars(idx)
      val start = if (st.contains(curr)) 1 else 0
      (start to 9).withFilter(d => !used.contains(d)).foreach(d => {
        used += d
        m += curr -> d
        if (f(idx + 1)) return true
        used -= d
        m += curr -> -1
      })
      false
    }

    f(0)
  }
}
