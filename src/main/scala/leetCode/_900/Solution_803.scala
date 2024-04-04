package leetCode._900

object Solution_803 {
  private val TOP: Int = 2
  private val BRICK: Int = 1
  private val DIRS: Array[Array[Int]] = Array(Array(1, 0), Array(-1, 0), Array(0, 1), Array(0, -1))

  def hitBricks(grid: Array[Array[Int]], hits: Array[Array[Int]]): Array[Int] = {
    val res = Array.fill(hits.length)(0)

    def dfs(i: Int, j: Int, grid: Array[Array[Int]]): Int = {
      if (i < 0 || i >= grid.length || j < 0 || j >= grid.head.length || grid(i)(j) != BRICK) 0
      else {
        grid(i)(j) = 2
        dfs(i + 1, j, grid) + dfs(i - 1, j, grid) + dfs(i, j + 1, grid) + dfs(i, j - 1, grid) + 1
      }
    }

    def isConnected(i: Int, j: Int, grid: Array[Array[Int]]): Boolean =
      if (i == 0) true
      else DIRS.exists(d => {
        val x = i + d.head
        val y = j + d(1)
        x >= 0 && x < grid.length && y >= 0 && y < grid(0).length && grid(x)(y) == TOP
      })

    hits.foreach(hit => grid(hit.head)(hit(1)) -= 1)

    grid.head.indices.foreach(dfs(0, _, grid))

    hits.indices.reverse.foreach(i => {
      val x = hits(i).head
      val y = hits(i)(1)
      grid(x)(y) += 1
      if (grid(x)(y) == BRICK && isConnected(x, y, grid)) res(i) = dfs(x, y, grid) - 1
    })
    res
  }
}
