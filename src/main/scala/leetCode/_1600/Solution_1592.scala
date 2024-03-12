package leetCode._1600

import scala.collection.mutable.ArrayBuffer

object Solution_1592 {
  def reorderSpaces(text: String): String = {
    val seq = ArrayBuffer[String]()
    var n = 0
    var i = 0
    var t = 0
    var word = ""
    while (i < text.length) {
      if (text(i) == ' ') {
        if (word != "") {
          seq.append(word)
          word = ""
        }
        n += 1
        t = 1
      } else {
        word = word.concat(text(i).toString)
        t = 0
      }
      i += 1
    }
    if (word != "") seq.append(word)
    if (seq.length == 1) return seq.head.concat(" " * n)
    val a = n / (seq.length - 1)
    val remain = n - a * (seq.length - 1)
    seq.mkString(" " * a).concat(" " * remain)
  }
}
