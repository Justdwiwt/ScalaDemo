package leetCode._1600

object Solution_1568 {
  var m: Int = 0
  var n: Int = 0
  var used: Array[Array[Boolean]] = _
  private val directions: Array[Array[Int]] = Array(Array(-1, 0), Array(0, -1), Array(1, 0), Array(0, 1))

  def minDays(grid: Array[Array[Int]]): Int = {
    m = grid.length
    n = grid.head.length
    used = Array.ofDim[Boolean](m, n)

    if (check(grid)) 0
    else {
      val res = grid.indices.flatMap(i => grid.head.indices.withFilter(j => grid(i)(j) == 1).map(j => {
        grid(i)(j) = 0
        val res = if (check(grid)) 1 else 2
        grid(i)(j) = 1
        res
      })).min
      res
    }
  }

  private def check(grid: Array[Array[Int]]): Boolean = {
    var count = 0
    used = Array.ofDim[Boolean](m, n)

    grid.indices.foreach(i => grid.head.indices.withFilter(j => !used(i)(j) && grid(i)(j) == 1).foreach(j => {
      count += 1
      dfs(grid, i, j)
    }))
    count > 1 || count == 0
  }

  private def dfs(grid: Array[Array[Int]], i: Int, j: Int): Unit = {
    used(i)(j) = true

    directions.foreach { case Array(dx, dy) =>
      val x = i + dx
      val y = j + dy
      if (inArea(x, y) && !used(x)(y) && grid(x)(y) == 1) dfs(grid, x, y)
    }
  }

  private def inArea(x: Int, y: Int): Boolean =
    x >= 0 && x < m && y >= 0 && y < n
}
