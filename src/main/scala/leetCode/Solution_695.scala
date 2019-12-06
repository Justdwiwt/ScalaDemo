package leetCode

object Solution_695 {

  def maxAreaOfIsland(grid: Array[Array[Int]]): Int = {
    if (grid.length == 0) return 0
    val flag = Array.fill(grid.length, grid(0).length)(false)
    var res = 0

    def func(v: (Int, Int)): List[(Int, Int)] = v match {
      case (x, y) => List((x + 1, y), (x - 1, y), (x, y + 1), (x, y - 1))
    }

    def inBound(v: (Int, Int)): Boolean = v match {
      case (x, y) => x >= 0 && y >= 0 && x < grid.length && y < grid(0).length
    }

    @scala.annotation.tailrec
    def dfs(list: List[(Int, Int)], acc: Int): Int = list match {
      case Nil => acc
      case _ =>
        list.foreach({ case (x, y) => flag(x)(y) = true })
        dfs(list.view.flatMap(func).filter(inBound).filter({ case (i, j) => !flag(i)(j) && grid(i)(j) == 1 }).distinct.force.toList, acc + list.length)
    }

    grid.indices.foreach(i => grid(0).indices.foreach(j => if (grid(i)(j) == 1 && !flag(i)(j)) res = res.max(dfs((i, j) :: Nil, 0))))
    res
  }

}
