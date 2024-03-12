package leetCode._2900

object Solution_2840 {
  def checkStrings(s1: String, s2: String): Boolean =
    f(s1, 0).equals(f(s2, 0)) && f(s1, 1).equals(f(s2, 1))

  private def f(s: String, i: Int): String = {
    val ch = Array.ofDim[Char](s.length / 2 + (if (s.length % 2 != 0 && i == 0) 1 else 0))
    var t = i
    while (t < s.length) {
      ch(t / 2) = s(t)
      t += 2
    }
    ch.sorted.mkString
  }
}
