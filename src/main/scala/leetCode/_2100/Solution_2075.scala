package leetCode._2100

import scala.collection.mutable

object Solution_2075 {
  def decodeCiphertext(encodedText: String, rows: Int): String = {
    val sb = new mutable.StringBuilder
    val len = encodedText.length
    val cols = len / rows
    val mat = Array.ofDim[Char](rows, cols)

    (0 until rows).foreach(r => (0 until cols).foreach(c => mat(r)(c) = encodedText.charAt(r * cols + c)))

    var startCol = 0
    while (startCol < cols) {
      var c = startCol
      var r = 0
      val tmp = new mutable.StringBuilder
      while (r < rows && c < cols) {
        if (mat(r)(c) == ' ' && c == cols - 1) {}
        else tmp += mat(r)(c)
        r += 1
        c += 1
      }
      if (tmp.toString.trim.isEmpty && c == cols) return sb.toString
      sb ++= tmp
      startCol += 1
    }

    sb.toString
  }
}
