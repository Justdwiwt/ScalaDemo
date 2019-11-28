package leetCode

object Solution_63 {
  def uniquePathsWithObstacles(obstacleGrid: Array[Array[Int]]): Int = {
    if (obstacleGrid.isEmpty || obstacleGrid(0).isEmpty || (obstacleGrid(0)(0) == 1)) return 0
    val dp = Array.fill(obstacleGrid(0).length)(0L)
    dp(0) = 1
    obstacleGrid.indices.foreach(i => obstacleGrid(0).indices.foreach(j =>
      if (obstacleGrid(i)(j) == 1) dp(j) = 0
      else if (j > 0) dp(j) += dp(j - 1)
    ))
    dp(obstacleGrid(0).length - 1).toInt
  }
}
