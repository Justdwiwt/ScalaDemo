package leetCode

object Solution_2663 {
  def smallestBeautifulString(s: String, k: Int): String = {
    val M = k + 'a'
    val ch = s.toCharArray
    val n = ch.length
    var idx = n - 1
    ch(idx) = (ch(idx) + 1).toChar
    while (idx < n) {
      if (ch(idx) == M) {
        if (idx == 0) return ""
        ch(idx) = 'a'
        idx -= 1
        ch(idx) = (ch(idx) + 1).toChar
      } else if (idx > 0 && ch(idx) == ch(idx - 1) || idx > 1 && ch(idx) == ch(idx - 2)) ch(idx) = (ch(idx) + 1).toChar
      else idx += 1
    }
    ch.mkString
  }
}
