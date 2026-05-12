package leetCode._3900

object Solution_3881 {
  private val MOD = 1000000007L

  private def modPow(a: Long, b: Long): Long = {
    @annotation.tailrec
    def dfs(base: Long, exp: Long, acc: Long): Long =
      if (exp == 0) acc
      else if ((exp & 1) == 1)
        dfs(base * base % MOD, exp >> 1, acc * base % MOD)
      else
        dfs(base * base % MOD, exp >> 1, acc)

    dfs(a, b, 1L)
  }

  def countVisiblePeople(n: Int, pos: Int, k: Int): Int = {
    if (k < 0 || k > n - 1) 0
    else {
      val fact = (1 until n).foldLeft(1L)((acc, x) => acc * x % MOD)

      val invK = modPow(
        (1 to k).foldLeft(1L)((acc, x) => acc * x % MOD),
        MOD - 2
      )

      val invNK = modPow(
        (1 to (n - 1 - k)).foldLeft(1L)((acc, x) => acc * x % MOD),
        MOD - 2
      )

      ((fact * invK % MOD) * invNK % MOD * 2 % MOD).toInt
    }
  }
}
