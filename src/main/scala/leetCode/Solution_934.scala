package leetCode

object Solution_934 {
  def shortestBridge(A: Array[Array[Int]]): Int = {
    var res = 0
    A.indices.foreach(i => A(i).indices.foreach(j => if (A(i)(j) == 1) {
      dfs(A, i, j)
      while (!bfs(A)) res += 1
      return res
    }))
    -1
  }

  def bfs(grid: Array[Array[Int]]): Boolean = {
    grid.indices.foreach(i => grid.indices.foreach(j => if (grid(i)(j) == 2) {
      if (color(grid, i - 1, j) || color(grid, i + 1, j) || color(grid, i, j - 1) || color(grid, i, j + 1))
        return true
    }))
    grid.indices.foreach(i => grid.indices.foreach(j => if (grid(i)(j) == 3) grid(i)(j) = 2))
    false
  }

  def color(grid: Array[Array[Int]], i: Int, j: Int): Boolean = {
    if (i < 0 || i >= grid.length || j < 0 || j >= grid.length) return false
    if (grid(i)(j) == 1) return true
    if (grid(i)(j) == 0) grid(i)(j) = 3
    false
  }

  def dfs(grid: Array[Array[Int]], i: Int, j: Int): Unit = {
    if (i < 0 || i >= grid.length || j < 0 || j >= grid.head.length || grid(i)(j) != 1)
      return
    grid(i)(j) = 2
    dfs(grid, i - 1, j)
    dfs(grid, i + 1, j)
    dfs(grid, i, j - 1)
    dfs(grid, i, j + 1)
  }
}
