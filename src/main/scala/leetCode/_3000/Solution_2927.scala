package leetCode._3000

object Solution_2927 {
  def distributeCandies(n: Int, limit: Int): Long =
    c2(n + 2) - 3 * c2(n - limit + 1) + 3 * c2(n - 2 * limit) - c2(n - 3 * limit - 1)

  private def c2(n: Int): Long =
    if (n > 1) n.toLong * (n - 1) / 2 else 0
}
