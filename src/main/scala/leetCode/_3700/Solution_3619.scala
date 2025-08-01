package leetCode._3700

object Solution_3619 {
  def countIslands(grid: Array[Array[Int]], k: Int): Int = {
    val m = grid.length
    val n = grid.head.length
    val original = grid.map(_.toVector).toVector

    def updateGrid(g: Vector[Vector[Int]], i: Int, j: Int, v: Int): Vector[Vector[Int]] =
      g.updated(i, g(i).updated(j, v))

    def dfs(i: Int, j: Int, g: Vector[Vector[Int]]): (Int, Vector[Vector[Int]]) =
      if (i < 0 || i >= m || j < 0 || j >= n || g(i)(j) == 0) (0, g)
      else {
        val value = g(i)(j)
        val g0 = updateGrid(g, i, j, 0)
        val neighbors = List((0, 1), (0, -1), (1, 0), (-1, 0))

        neighbors.foldLeft((value, g0)) { case (acc, delta) =>
          val (accSum, accGrid) = acc
          val (dx, dy) = delta
          val (s, newGrid) = dfs(i + dx, j + dy, accGrid)
          (accSum + s, newGrid)
        }
      }

    @scala.annotation.tailrec
    def loop(i: Int, j: Int, g: Vector[Vector[Int]], acc: Int): Int =
      if (i == m) acc
      else if (j == n) loop(i + 1, 0, g, acc)
      else if (g(i)(j) == 0) loop(i, j + 1, g, acc)
      else {
        val (size, newGrid) = dfs(i, j, g)
        val delta = if (size % k == 0) 1 else 0
        loop(i, j + 1, newGrid, acc + delta)
      }

    loop(0, 0, original, 0)
  }
}
