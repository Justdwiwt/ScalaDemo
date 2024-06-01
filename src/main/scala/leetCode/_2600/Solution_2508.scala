package leetCode._2600

object Solution_2508 {
  def isPossible(n: Int, edges: List[List[Int]]): Boolean = {
    val g = Array.fill[Set[Int]](n + 1)(Set())
    edges.foreach {
      case x :: y :: Nil =>
        g(x) += y
        g(y) += x
      case _ =>
    }

    val odd = (1 to n).filter(g(_).size % 2 != 0).toList
    val m = odd.size
    if (m == 0) return true
    if (m == 2) {
      val List(x, y) = odd
      if (!g(x).contains(y)) return true
      if ((1 to n).exists(i => i != x && i != y && !g(i).contains(x) && !g(i).contains(y))) return true
      return false
    }
    if (m == 4) {
      val List(a, b, c, d) = odd
      return !g(a).contains(b) && !g(c).contains(d) || !g(a).contains(c) && !g(b).contains(d) || !g(a).contains(d) && !g(b).contains(c)
    }
    false
  }
}
