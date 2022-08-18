package leetCode

object Solution_2373 {
  def largestLocal(grid: Array[Array[Int]]): Array[Array[Int]] = grid
    .sliding(3)
    .map(_.transpose.sliding(3).map(_.map(_.max).max).toArray)
    .toArray
}
