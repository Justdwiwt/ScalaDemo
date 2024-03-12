package leetCode._1800

object Solution_1753 {
  def maximumScore(a: Int, b: Int, c: Int): Int = {
    val l = List(a, b, c).sorted
    (l.head + l(1)).min(l(2)) + (l.head + l(1) - l(2)).max(0) / 2
  }
}
