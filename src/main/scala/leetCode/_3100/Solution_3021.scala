package leetCode._3100

object Solution_3021 {
  def flowerGame(n: Int, m: Int): Long = f(n, m)

  private def f(n: Long, m: Long): Long =
    (n >> 1) * (m + 1 >> 1) + (n + 1 >> 1) * (m >> 1)
}
