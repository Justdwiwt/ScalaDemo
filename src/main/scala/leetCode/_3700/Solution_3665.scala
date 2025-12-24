package leetCode._3700

object Solution_3665 {
  private val M = 1000000007

  def uniquePaths(grid: Array[Array[Int]]): Int = {
    val m = grid.length
    val n = grid.head.length

    def dfs(i: Int, j: Int, k: Int, memo: Map[(Int, Int, Int), Int]): (Int, Map[(Int, Int, Int), Int]) = {
      if (i < 0 || j < 0) return (0, memo)
      if (i == 0 && j == 0) return (1, memo)
      memo.get((i, j, k)) match {
        case Some(v) => (v, memo)
        case None =>
          val (res, newMemo) = grid(i)(j) match {
            case 0 =>
              val (a, m1) = dfs(i, j - 1, 0, memo)
              val (b, m2) = dfs(i - 1, j, 1, m1)
              ((a + b) % M, m2)
            case _ if k == 0 => dfs(i - 1, j, 1, memo)
            case _ => dfs(i, j - 1, 0, memo)
          }
          (res, newMemo + ((i, j, k) -> res))
      }
    }

    dfs(m - 1, n - 1, 0, Map.empty)._1
  }
}
