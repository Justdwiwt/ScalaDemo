package leetCode._1500

object Solution_1405 {
  private def f(a: Int, b: Int, c: Int, aa: String, bb: String, cc: String): String = {
    if (a < b) return f(b, a, c, bb, aa, cc)
    if (b < c) return f(a, c, b, aa, cc, bb)
    if (b == 0) return List.fill(2.min(a))(aa).mkString
    val tA: Int = 2.min(a)
    val tB: Int = if (a - tA >= b) 1 else 0
    List.fill(tA)(aa).mkString + List.fill(tB)(bb).mkString + f(a - tA, b - tB, c, aa, bb, cc)
  }

  def longestDiverseString(a: Int, b: Int, c: Int): String =
    f(a, b, c, "a", "b", "c")
}
