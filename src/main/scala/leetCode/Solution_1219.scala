package leetCode

object Solution_1219 {

  private val dirs = Array(Array(1, 0), Array(0, 1), Array(-1, 0), Array(0, -1))

  def getMaximumGold(grid: Array[Array[Int]]): Int = {
    var res = 0
    grid.indices.foreach(i => grid(0).indices.foreach(j => if (grid(i)(j) > 0) res = res.max(dfs(grid, i, j))))
    res
  }

  def dfs(grid: Array[Array[Int]], i: Int, j: Int): Int = {
    if (i < 0 || i >= grid.length || j < 0 || j >= grid(0).length || grid(i)(j) == 0) return 0
    val v = grid(i)(j)
    grid(i)(j) = 0
    var res = 0
    dirs.foreach(arr => {
      val r = i + arr(0)
      val c = j + arr(1)
      res = res.max(v + dfs(grid, r, c))
    })
    grid(i)(j) = v
    res
  }

}
