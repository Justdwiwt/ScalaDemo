package leetCode._3500

object Solution_3459 {
  def lenOfVDiagonal(grid: Array[Array[Int]]): Int = {
    val n = grid.length
    val m = grid.head.length
    val INF = Int.MaxValue
    val arr = Array.fill(n, m, 2)(-INF)
    val dir = Array(Array(1, 1), Array(1, -1), Array(-1, -1), Array(-1, 1))

    def check(i: Int, j: Int, ii: Int, jj: Int): Boolean = {
      if (ii < 0 || jj < 0 || ii >= n || jj >= m) return false
      val x = grid(i)(j)
      val y = grid(ii)(jj)
      if (x == 2) y != 2
      else y == 2
    }

    def dp(i: Int, j: Int, t: Int, k: Int): Int = {
      if (grid(i)(j) == 1) return 1
      var ret = arr(i)(j)(t)
      if (ret > -INF) return ret
      ret = -INF + 1

      if (t == 0) {
        val ii = i - dir(k)(0)
        val jj = j - dir(k)(1)
        if (check(i, j, ii, jj)) ret = ret.max(dp(ii, jj, 0, k) + 1)
      } else {
        val ii = i - dir((k + 1) % 4)(0)
        val jj = j - dir((k + 1) % 4)(1)
        if (check(i, j, ii, jj)) ret = ret.max(dp(ii, jj, 0, k) + 1).max(dp(ii, jj, 1, k) + 1)
      }
      arr(i)(j)(t) = ret
      ret
    }

    var ans = 0
    (0 until 4).foreach(k => {
      grid.indices.foreach(i => grid.head.indices.foreach(j => {
        arr(i)(j)(0) = -INF
        arr(i)(j)(1) = -INF
      }))
      grid.indices.foreach(i => grid.head.indices.foreach(j => ans = ans.max(dp(i, j, 0, k).max(dp(i, j, 1, k)))))
    })
    ans
  }
}
