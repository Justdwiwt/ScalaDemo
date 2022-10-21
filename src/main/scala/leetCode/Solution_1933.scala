package leetCode

object Solution_1933 {
  def isDecomposable(s: String): Boolean = {
    val str = s + 'a'
    val ch = str.toCharArray
    var cnt = 1
    var num = 0
    ch.indices.dropRight(1).foreach(i =>
      if (ch(i) == ch(i + 1)) cnt += 1
      else {
        if (cnt % 3 == 1) return false
        else if (cnt % 3 == 2) num += 1
        cnt = 1
        if (num > 1) return false
      }
    )
    num == 1
  }
}
