package leetCode._3200

object Solution_3179 {
  private def comb(n: Int, r: Int, M: Int): Int = {
    if (r > n) return 0
    if (r == 0 || r == n) return 1
    val numer = (0 until r).foldLeft(1L)((acc, i) => acc * (n - i) % M)
    val denom = (1 to r).foldLeft(1L)((acc, i) => acc * i % M)
    (numer * modInverse(denom, M) % M).toInt
  }

  private def modInverse(a: Long, M: Long): Long = {
    def power(x: Long, y: Long, m: Long): Long = {
      if (y == 0) return 1
      val p = power(x, y / 2, m) % m
      val res = (p * p) % m
      if (y % 2 == 0) res else (x * res) % m
    }

    power(a, M - 2, M)
  }

  def valueAfterKSeconds(n: Int, k: Int): Int =
    comb(n + k - 1, k, 1000000007)
}
