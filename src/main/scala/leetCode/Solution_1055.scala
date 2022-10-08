package leetCode

object Solution_1055 {
  def shortestWay(source: String, target: String): Int = {
    val ch1 = source.toCharArray
    val ch2 = target.toCharArray
    val ch = Array.fill(26)(0)
    ch1.foreach(c => ch(c - 'a') += 1)
    ch2.foreach(c => if (ch(c - 'a') == 0) return -1)
    var res = 0
    var i = 0
    while (i < target.length) {
      source.indices.foreach(j => if (i < target.length && ch2(i) == ch1(j)) i += 1)
      i -= 1
      res += 1
      i += 1
    }
    res
  }
}
