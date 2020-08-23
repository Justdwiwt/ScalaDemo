package leetCode

object Solution_807 {
  def maxIncreaseKeepingSkyline(grid: Array[Array[Int]]): Int = {
    var res = 0
    val row = Array.fill(grid.length)(0)
    val col = Array.fill(grid(0).length)(0)
    grid.indices.foreach(i => grid(i).indices.foreach(j => {
      row(i) = row(i).max(grid(i)(j))
      col(j) = col(j).max(grid(i)(j))
    }))
    grid.indices.foreach(i => grid(i).indices.foreach(j => res += (row(i).min(col(j)) - grid(i)(j))))
    res
  }
}
