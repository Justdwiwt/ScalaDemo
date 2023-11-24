package leetCode

object Solution_2928 {
  def distributeCandies(n: Int, limit: Int): Int =
    (0.max(n - 2 * limit) to limit.min(n))./:(0)((res, i) => res + limit.min(n - i) - 0.max(n - i - limit) + 1)
}
