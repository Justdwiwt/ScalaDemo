package leetCode

object Solution_64 {
  def minPathSum(grid: Array[Array[Int]]): Int = (grid.length, grid.headOption.map(_.length).getOrElse(0)) match {
    case (m, n) if m > 0 && n > 0 =>
      val dp = Array.fill(m, n)(grid(m - 1)(n - 1))
      (1 to m + n).foreach(k => (0.max((m - 1) - k) to (m - 1).min(m + n - k - 2)).foreach(i => {
        val j = m + n - i - k - 2
        dp(i)(j) = grid(i)(j) + Seq((i + 1, j), (i, j + 1))
          .collect({ case (x, y) if dp.isDefinedAt(x) && dp(x).isDefinedAt(y) => dp(x)(y) }).min
      }))
      dp(0)(0)
  }
}
