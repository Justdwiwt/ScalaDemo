package leetCode

object Solution_2017 {
  def gridGame(grid: Array[Array[Int]]): Long = {
    val suffixSums = grid.head.scanRight(0L)(_ + _).drop(1)
    val prefixSums = grid.last.scanLeft(0L)(_ + _).dropRight(1)

    suffixSums.zip(prefixSums)./:(Long.MaxValue) {
      case (minRobot2Points, (suffixSum, prefixSum)) =>
        minRobot2Points.min(suffixSum.max(prefixSum))
    }
  }
}
