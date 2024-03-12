package leetCode._3000

object Solution_2929 {
  def distributeCandies(n: Int, limit: Int): Long =
    (0.max(n - 2 * limit) to limit.min(n))./:(0L)((res, i) => res + limit.min(n - i) - 0.max(n - i - limit) + 1)
}
