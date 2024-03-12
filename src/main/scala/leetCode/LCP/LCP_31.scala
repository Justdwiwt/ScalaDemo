package leetCode.LCP

object LCP_31 {
  def escapeMaze(maze: Array[Array[String]]): Boolean = {
    val m = maze.head.length
    val n = maze.head.head.length
    val t = maze.length
    val dp = Array.fill(t, m, n)(0)
    val preUse = Array.fill(m, n)(0)

    val next = Array(0, 0, 0, 1, 2, 4)
    val preS = Array(0, 0, 2, 3, 3, -1)

    (0 until t).foreach(k => dp(k).head(0) = 5)

    (1 until t).foreach(ct => {
      (0 until m).foreach(i => {
        (0 until n).withFilter(j => i != 0 || j != 0).foreach(j => {
          val pre = calMax(ct - 1, i, j)
          if (maze(ct)(i)(j) != ',') {
            dp(ct)(i)(j) = next(pre).max(preS(preUse(i)(j)))
            preUse(i)(j) = dp(ct)(i)(j)
          } else dp(ct)(i)(j) = pre
        })
      })
      if (dp(ct)(m - 1)(n - 1) > 0) return true
    })

    def calMax(t: Int, i: Int, j: Int): Int = {
      var mx = dp(t)(i)(j)
      if (i > 0) mx = mx.max(dp(t)(i - 1)(j))
      if (j > 0) mx = mx.max(dp(t)(i)(j - 1))
      if (i < m - 1) mx = mx.max(dp(t)(i + 1)(j))
      if (j < n - 1) mx = mx.max(dp(t)(i)(j + 1))
      mx
    }

    false
  }
}
