package leetCode._1600

object Solution_1541 {
  def minInsertions(s: String): Int = {
    val ch = s.toCharArray
    var res = 0
    var l = 0
    var i = 0
    while (i < ch.length) {
      if (ch(i) == '(') l += 1
      else {
        if (l == 0) res += 1
        else l -= 1
        if (i == ch.length - 1 || ch(i + 1) != ')') res += 1
        else i += 1
      }
      i += 1
    }
    res + l * 2
  }
}
