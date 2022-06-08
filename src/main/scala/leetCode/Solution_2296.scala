package leetCode

import scala.collection.mutable

object Solution_2296 {

}

class TextEditor() {

  var sb = new mutable.StringBuilder()
  var cur = 0

  def addText(text: String) {
    sb.insert(cur, text)
    cur += text.length
  }

  def deleteText(k: Int): Int = {
    if (cur <= k) {
      val old = cur
      sb.replace(0, old, "")
      cur = 0
      old
    } else {
      sb.replace(cur - k, cur, "")
      cur -= k
      k
    }
  }

  def cursorLeft(k: Int): String = {
    if (cur >= k) {
      cur -= k
      if (cur >= 10) sb.substring(cur - 10, cur)
      else sb.substring(0, cur)
    } else {
      cur = 0
      ""
    }
  }

  def cursorRight(k: Int): String = {
    val length = sb.length
    if (cur + k <= length) cur += k
    else cur = length
    if (cur >= 10) sb.substring(cur - 10, cur)
    else sb.substring(0, cur)
  }

}