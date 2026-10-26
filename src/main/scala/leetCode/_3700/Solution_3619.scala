package leetCode._3700

object Solution_3619 {
  def countIslands(grid: Array[Array[Int]], k: Int): Int = {
    val m = grid.length
    val n = grid.head.length
    val dirs = List((0, 1), (0, -1), (1, 0), (-1, 0))

    def dfs(i: Int, j: Int): Long =
      if (i < 0 || i >= m || j < 0 || j >= n || grid(i)(j) == 0) 0L
      else {
        val v = grid(i)(j)
        grid(i)(j) = 0
        v.toLong + dirs.map { case (dx, dy) => dfs(i + dx, j + dy) }.sum
      }

    grid
      .indices
      .flatMap(i => grid
        .head
        .indices
        .withFilter(grid(i)(_) != 0)
        .map { j => val sum = dfs(i, j); (j, sum) }
        .withFilter { case (_, sum) => sum % k == 0 }
        .map { case (_, _) => 1 }
      ).sum
  }
}
