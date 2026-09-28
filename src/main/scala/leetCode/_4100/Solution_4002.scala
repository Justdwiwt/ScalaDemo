package leetCode._4100

object Solution_4002 {
  val MOD = 1000000007L

  def countValidSequences(n: Int, k: Int): Int = {
    def pow(a: Long, n: Long): Long =
      if (n == 0) 1
      else {
        val x = pow(a, n / 2)
        x * x % MOD * (if (n % 2 == 1) a else 1) % MOD
      }

    def comb(n: Int, k: Int): Long =
      if (k < 0 || k > n) 0
      else {
        val (num, den) = (1 to k).foldLeft((1L, 1L)) {
          case ((a, b), i) =>
            (a * (n - k + i) % MOD, b * i % MOD)
        }
        num * pow(den, MOD - 2) % MOD
      }

    val ans = comb(n - 1, k - 1)
    val sub =
      if ((n + k) % 2 == 0)
        comb((n + k) / 2 - 1, k - 1)
      else 0

    ((ans - sub + MOD) % MOD).toInt
  }
}
