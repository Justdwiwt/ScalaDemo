package leetCode

object Solution_63 {
  def uniquePathsWithObstacles(obstacleGrid: Array[Array[Int]]): Int = obstacleGrid
    .iterator
    ./:(1 +: Vector.fill(obstacleGrid.head.length - 1)(0))((counts, obstacles) => counts
      .iterator
      .zip(obstacles.iterator)
      .scanLeft(0) { case (left, (up, obs)) => if (obs == 1) 0 else left + up }
      .drop(1)
      .toVector
    )
    .last
}
