package leetCode._2600

object Solution_2556 {
  def isPossibleToCutPath(grid: Array[Array[Int]]): Boolean = {
    def f(grid: Array[Array[Int]], i: Int, j: Int): Boolean = {
      if (i == grid.length - 1 && j == grid.head.length - 1) return true
      if (i >= grid.length || j >= grid.head.length || grid(i)(j) == 0) return false
      grid(i)(j) = 0
      f(grid, i + 1, j) || f(grid, i, j + 1)
    }

    if (!f(grid, 0, 0)) return true
    grid.head(0) = 1
    if (!f(grid, 0, 0)) return true
    false
  }
}
