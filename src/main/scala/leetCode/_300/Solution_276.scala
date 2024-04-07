package leetCode._300

object Solution_276 {
  def numWays(n: Int, k: Int): Int =
    if (n == 0 || k == 0) 0
    else if (n == 1) k
    else (2 until n)
      .foldLeft((k, k * k)) { case ((prev1, prev2), _) =>
        val cur = prev1 * (k - 1) + prev2 * (k - 1)
        (prev2, cur)
      }
      ._2
}
