package leetCode

object Solution_2939 {
  def maximumXorProduct(a: Long, b: Long, n: Int): Int = {
    val M = 1000000007

    @scala.annotation.tailrec
    def dfs(a: Long, b: Long, bt: Long): Long =
      if (n == 0 || bt == 0) ((a % M) * (b % M)) % M
      else if ((a.min(b) & bt) > 0) dfs(a, b, bt >> 1)
      else dfs(a ^ bt, b ^ bt, bt >> 1)

    dfs(a, b, 1L << (n - 1)).toInt
  }
}
