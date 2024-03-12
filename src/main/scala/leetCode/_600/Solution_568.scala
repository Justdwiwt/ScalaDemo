package leetCode._600

object Solution_568 {
  def maxVacationDays(flights: Array[Array[Int]], days: Array[Array[Int]]): Int = {
    def dfs(now: Int, n: Int, memo: Array[Array[Int]]): Int = {
      if (n == memo.head.length) return 0
      if (memo(now)(n) > 0) return memo(now)(n)
      days.indices.foreach(i => if (i == now || flights(now)(i) == 1) memo(now)(n) = memo(now)(n).max(dfs(i, n + 1, memo) + days(i)(n)))
      memo(now)(n)
    }

    dfs(0, 0, Array.ofDim[Int](days.length, days.head.length))
  }
}
