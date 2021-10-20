package leetCode

object Offer_105 {
  def maxAreaOfIsland(grid: Array[Array[Int]]): Int = {
    var res = 0
    grid.indices.foreach(i => grid.head.indices.foreach(j => res = res.max(dfs(grid, i, j, grid.length, grid.head.length))))
    res
  }

  def dfs(grid: Array[Array[Int]], row: Int, col: Int, m: Int, n: Int): Int = {
    if (row < 0 || row >= m || col < 0 || col >= n || grid(row)(col) == 0) return 0
    grid(row)(col) = 0
    1 + dfs(grid, row + 1, col, m, n) + dfs(grid, row, col + 1, m, n) + dfs(grid, row - 1, col, m, n) + dfs(grid, row, col - 1, m, n)
  }
}
