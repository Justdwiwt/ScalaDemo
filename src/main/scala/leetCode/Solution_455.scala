package leetCode

object Solution_455 {
  def findContentChildren(g: Array[Int], s: Array[Int]): Int = {
    val G = g.sorted
    val S = s.sorted
    var res = 0
    var p = 0
    while (res < G.length && p < S.length) {
      if (G(res) <= S(p)) res += 1
      p += 1
    }
    res
  }
}
