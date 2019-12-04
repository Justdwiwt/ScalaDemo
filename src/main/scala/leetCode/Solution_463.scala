package leetCode

object Solution_463 {
  def islandPerimeter(grid: Array[Array[Int]]): Int = {
    if (grid.length == 0) return 0
    var res = 0
    grid.indices.foreach(i => grid(0).indices.foreach(j =>
      if (grid(i)(j) == 1) {
        if (i == 0 || grid(i - 1)(j) == 0) res += 1
        if (j == 0 || grid(i)(j - 1) == 0) res += 1
      }))
    res = 2 * res
    res
  }
}
