package leetCode._900

object Solution_892 {
  def surfaceArea(grid: Array[Array[Int]]): Int = {
    var res = 0
    grid.indices.foreach(i => grid.indices.foreach(j => {
      if (grid(i)(j) > 0) res += 4 * grid(i)(j) + 2
      if (i > 0) res -= grid(i)(j).min(grid(i - 1)(j)) * 2
      if (j > 0) res -= grid(i)(j).min(grid(i)(j - 1)) * 2
    }))
    res
  }
}
