package leetCode._1200

import scala.collection.mutable

object Solution_1156 {
  def maxRepOpt1(text: String): Int = {
    val m = mutable.Map.empty[Char, Int]
    text.indices.foreach(i => {
      val c = text.charAt(i)
      m += c -> (m.getOrElse(c, 0) + 1)
    })

    var res = 0
    var i = 0
    while (i < text.length) {
      var j = i
      while (j < text.length && text.charAt(j) == text.charAt(i))
        j += 1
      val cur = j - i

      if (cur < m.getOrElse(text.charAt(i), 0) && (j < text.length || i > 0))
        res = res.max(cur + 1)

      var k = j + 1
      while (k < text.length && text.charAt(k) == text.charAt(i))
        k += 1
      res = res.max((k - i).min(m.getOrElse(text.charAt(i), 0)))
      i = j
    }
    res
  }
}
