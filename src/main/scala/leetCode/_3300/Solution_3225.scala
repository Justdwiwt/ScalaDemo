package leetCode._3300

object Solution_3225 {
  private var n: Int = 0
  private var colSum: Array[Array[Long]] = _
  private var memo: Array[Array[Array[Long]]] = _

  def maximumScore(grid: Array[Array[Int]]): Long = {
    n = grid.length
    colSum = Array.ofDim[Long](n, n + 1)
    (0 until n)
      .foreach(j => (0 until n)
        .foreach(i => colSum(j)(i + 1) = colSum(j)(i) + grid(i)(j)))

    memo = Array.ofDim[Long](n + 1, n + 1, 2)
    (0 to n)
      .foreach(a => (0 to n)
        .foreach(b => (0 until 2)
          .foreach(memo(a)(b)(_) = -1)))

    var ans = 0L
    (0 to n).foreach(i => ans = ans.max(dfs(n - 2, i, 0)))
    ans
  }

  private def dfs(j: Int, pre: Int, dec: Int): Long = {
    if (j < 0) return 0
    if (memo(j)(pre)(dec) != -1) return memo(j)(pre)(dec)

    var res = 0L
    (0 to n).foreach(cur =>
      if (pre == cur) res = res.max(dfs(j - 1, cur, 0))
      else if (pre > cur) res = res.max(dfs(j - 1, cur, 1) + colSum(j)(pre) - colSum(j)(cur))
      else if (dec == 1) {
        if (pre != 1) res = res.max(dfs(j - 1, cur, 0))
      } else res = res.max(dfs(j - 1, cur, 0) + colSum(j + 1)(cur) - colSum(j + 1)(pre)))
    memo(j)(pre)(dec) = res
    res
  }
}
