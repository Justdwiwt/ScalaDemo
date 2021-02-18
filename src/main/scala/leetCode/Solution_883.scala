package leetCode

object Solution_883 {
  def projectionArea(grid: Array[Array[Int]]): Int =
    Array(
      grid.map(_.max).sum,
      grid.transpose.map(_.max).sum,
      grid.map(_.count(_ != 0)).sum
    ).sum
}
