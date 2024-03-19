package leetCode._2200

object Solution_2132 {
  def possibleToStamp(grid: Array[Array[Int]], stampHeight: Int, stampWidth: Int): Boolean = {
    val (m, n) = (grid.length, grid.head.length)

    def indices(): Seq[(Int, Int)] = grid
      .indices
      .flatMap(r => grid.head.indices.map((r, _)))

    def acc(grid: Array[Array[Int]]): Array[Array[Int]] = {
      val dp = Array.fill(m + 1, n + 1)(0)
      indices().foreach { case (r, c) => dp(r + 1)(c + 1) = dp(r + 1)(c) + dp(r)(c + 1) - dp(r)(c) + grid(r)(c) }
      dp
    }

    def sum(arr: Array[Array[Int]], r1: Int, c1: Int, r2: Int, c2: Int): Int =
      arr(r2 + 1)(c2 + 1) - arr(r1)(c2 + 1) - arr(r2 + 1)(c1) + arr(r1)(c1)

    val dp = acc(grid)
    val diff = Array.fill(m + 1, n + 1)(0)
    (0 until n - stampWidth + 1).foreach(c => (0 until m - stampHeight + 1).foreach(r =>
      if (sum(dp, r, c, r + stampHeight - 1, c + stampWidth - 1) == 0) {
        diff(r)(c) += 1
        diff(r)(c + stampWidth) -= 1
        diff(r + stampHeight)(c) -= 1
        diff(r + stampHeight)(c + stampWidth) += 1
      }))

    val dp2 = acc(diff)
    indices().forall { case (r, c) => grid(r)(c) == 1 || dp2(r + 1)(c + 1) != 0 }
  }
}
