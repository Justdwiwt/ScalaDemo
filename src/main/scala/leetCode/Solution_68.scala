package leetCode

import scala.collection.mutable.ListBuffer

object Solution_68 {
  def fullJustify(words: Array[String], maxWidth: Int): List[String] = {
    val res = new ListBuffer[String]()
    var i = 0
    while (i < words.length) {
      var j = i
      var len = 0
      while (j < words.length && len + words(j).length + j - i <= maxWidth) {
        len += words(j).length
        j += 1
      }
      val out = new StringBuilder
      var space = maxWidth - len
      (i until j).foreach(k => {
        out.append(words(k))
        if (space > 0) {
          var tmp = 0
          if (j == words.length) {
            if (j - k == 1) tmp = space
            else tmp = 1
          } else {
            if (j - k - 1 > 0) {
              if (space % (j - k - 1) == 0) tmp = space / (j - k - 1)
              else tmp = space / (j - k - 1) + 1
            } else tmp = space
          }
          out.append(tmp, ' ')
          space -= tmp
        }
      })
      res.append(out.toString)
      i = j
    }
    res.toList
  }
}
