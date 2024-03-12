package leetCode._2300

import scala.collection.mutable

object Solution_2296 {
  class TextEditor() {

    val sb = new mutable.StringBuilder()
    var cur = 0

    def addText(text: String): Unit = {
      sb.insert(cur, text)
      cur += text.length
    }

    def deleteText(k: Int): Int = {
      val t = cur.min(k)
      sb.delete(cur - t, cur)
      cur -= t
      t
    }

    def cursorLeft(k: Int): String = {
      cur -= k.min(cur)
      sb.substring((cur - 10).max(0), cur)
    }

    def cursorRight(k: Int): String = {
      cur = (cur + k).min(sb.length)
      sb.substring((cur - 10).max(0), cur)
    }

  }
}
