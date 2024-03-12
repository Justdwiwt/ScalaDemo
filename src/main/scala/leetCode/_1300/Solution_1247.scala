package leetCode._1300

object Solution_1247 {
  def minimumSwap(s1: String, s2: String): Int = {
    var p = 0
    var q = 0
    s1.indices.foreach(i => if (s1(i) != s2(i)) if (s1(i) != 'x') p += 1 else q += 1)
    if ((p + q) % 2 > 0) return -1
    p / 2 + q / 2 + 2 * (p % 2)
  }
}
