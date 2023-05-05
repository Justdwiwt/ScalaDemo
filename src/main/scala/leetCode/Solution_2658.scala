package leetCode

object Solution_2658 {
  def findMaxFish(grid: Array[Array[Int]]): Int = {
    var res = 0
    grid.indices.foreach(i => grid.head.indices.foreach(j => res = res.max(f(grid, i, j))))
    res
  }

  private def f(grid: Array[Array[Int]], i: Int, j: Int): Int =
    if (i < 0 || i >= grid.length || j < 0 || j >= grid.head.length) 0
    else {
      val cnt = grid(i)(j)
      grid(i)(j) = 0
      if (cnt == 0) 0
      else cnt + f(grid, i - 1, j) + f(grid, i + 1, j) + f(grid, i, j - 1) + f(grid, i, j + 1)
    }
}
