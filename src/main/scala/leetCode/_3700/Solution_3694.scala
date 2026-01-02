package leetCode._3700

object Solution_3694 {
  def distinctPoints(s: String, k: Int): Int = {
    val n = s.length
    val dir: Map[Char, Int] = Map(
      'L' -> (-(n + 1)),
      'R' -> (n + 1),
      'D' -> -1,
      'U' -> 1
    )

    (k until n).foldLeft((0, Set(0))) {
      case ((x, st), i) =>
        val nx = x + dir(s(i)) - dir(s(i - k))
        (nx, st + nx)
    }._2.size
  }
}
