package leetCode

object Solution_2734 {
  def smallestString(s: String): String = {
    val n = s.length
    var i = 0
    val ch = s.toCharArray
    while (i < n && ch(i) == 'a') i += 1
    if (i >= n) ch(i - 1) = 'z'
    else while (i < n && ch(i) != 'a') {
      ch(i) = (ch(i) - 1).toChar
      i += 1
    }
    ch.mkString
  }
}
