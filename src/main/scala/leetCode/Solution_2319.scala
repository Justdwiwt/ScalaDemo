package leetCode

object Solution_2319 {
  def checkXMatrix(grid: Array[Array[Int]]): Boolean = {
    grid.indices.foreach(i => grid.indices.foreach(j => {
      if (i == j || i + j == grid.length - 1) {
        if (grid(i)(j) == 0) return false
      } else if (grid(i)(j) != 0) return false
    }))
    true
  }
}
