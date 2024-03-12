package leetCode._1300

object Solution_1254 {

  private val dir = Array(Array(1, 0), Array(0, 1), Array(-1, 0), Array(0, -1))

  def closedIsland(grid: Array[Array[Int]]): Int = {
    if (grid == null || grid.length < 1) return 0
    var res = 0
    grid.indices.foreach(r => grid(0).indices.foreach(c => if (grid(r)(c) == 0) res += dfs(grid, r, c)))
    res
  }

  def dfs(grid: Array[Array[Int]], r: Int, c: Int): Int = {
    if (!check(grid, r, c)) return 0
    var res = 1
    if (grid(r)(c) == 0) {
      grid(r)(c) = 1
      dir.foreach(i => res = res.min(dfs(grid, r + i(0), c + i(1))))
    }
    res
  }

  def check(grid: Array[Array[Int]], r: Int, c: Int): Boolean = r >= 0 && r < grid.length && c >= 0 && c < grid(0).length

}
