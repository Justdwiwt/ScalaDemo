package leetCode

object Solution_883 {
  def projectionArea(grid: Array[Array[Int]]): Int = {
    var res = 0
    grid(0).indices.foreach(i => {
      var row = 0
      var col = 0
      grid(0).indices.foreach(j => {
        if (grid(i)(j) > 0) res += 1
        row = row.max(grid(i)(j))
        col = col.max(grid(j)(i))
      })
      res += row + col
    })
    res
  }
}
