package leetCode

object Solution_576 {
  def findPaths(m: Int, n: Int, N: Int, i: Int, j: Int): Int = {
    var res = 0L
    val M = 1000000007
    val dp = Array.tabulate[Long](m, n, 2)((_, _, _) => 0)

    def isBoundary(i: Int, j: Int): Boolean = i < 0 || i >= m || j < 0 || j >= n

    dp(i)(j)(0) = 1
    (0 until N).foreach(x => (0 until m).foreach(i => (0 until n).foreach(j => {
      val prev = x % 2
      val loc = (x + 1) % 2
      if (isBoundary(i - 1, j) && x + 1 <= N) res += dp(i)(j)(prev) % M
      else if (x + 1 < N) dp(i - 1)(j)(loc) += (dp(i)(j)(prev) % M)
      if (isBoundary(i + 1, j) && x + 1 <= N) res += dp(i)(j)(prev) % M
      else if (x + 1 < N) dp(i + 1)(j)(loc) += (dp(i)(j)(prev) % M)
      if (isBoundary(i, j - 1) && x + 1 <= N) res += dp(i)(j)(prev) % M
      else if (x + 1 < N) dp(i)(j - 1)(loc) += (dp(i)(j)(prev) % M)
      if (isBoundary(i, j + 1) && x + 1 <= N) res += dp(i)(j)(prev) % M
      else if (x + 1 < N) dp(i)(j + 1)(loc) += (dp(i)(j)(prev) % M)
      dp(i)(j)(prev) = 0
    })))
    (res % M).toInt
  }
}
