package leetCode._3900

object Solution_3882 {
  def minCost(grid: Array[Array[Int]]): Int = {
    val rows = grid.length
    val cols = grid.head.length

    val visited = Array.fill(rows, cols, 1024)(false)

    def dfs(r: Int, c: Int, xorSoFar: Int): Unit = {
      if (r >= rows || c >= cols) return

      val newXor = xorSoFar ^ grid(r)(c)

      if (visited(r)(c)(newXor)) return
      visited(r)(c)(newXor) = true

      dfs(r + 1, c, newXor)
      dfs(r, c + 1, newXor)
    }

    dfs(0, 0, 0)


    (0 until 1024).find(visited(rows - 1)(cols - 1)(_)).getOrElse(-1)
  }
}
