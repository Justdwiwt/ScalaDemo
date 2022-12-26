package leetCode

object Solution_2500 {
  def deleteGreatestValue(grid: Array[Array[Int]]): Int = grid
    .map(_.sorted)
    .transpose
    .map(_.max)
    .sum
}
