package leetCode

object Solution_200 {
  val diff = Vector((0, 1), (0, -1), (1, 0), (-1, 0))

  def numIslands(grid: Array[Array[Char]]): Int = {

    if (grid.isEmpty || grid.head.isEmpty) return 0

    val g = grid
    var res = 0

    grid.head.indices.foreach(x => grid.indices.withFilter(y => g(y)(x) == '1').foreach(y => {
      res += 1
      dfs(x, y)
    }))

    def dfs(x: Int, y: Int): Unit = (x, y) match {
      case (x, _) if x < 0 || x >= grid.head.length =>
      case (_, y) if y < 0 || y >= grid.length =>
      case (x, y) if g(y)(x) == '1' =>
        g(y)(x) = '0'
        diff.foreach(d => dfs(x + d._1, y + d._2))
      case _ =>
    }

    res
  }
}
