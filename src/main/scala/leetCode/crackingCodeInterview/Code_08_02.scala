package leetCode.crackingCodeInterview

object Code_08_02 {
  def pathWithObstacles(obstacleGrid: Array[Array[Int]]): List[List[Int]] = {
    var res = List.empty[List[Int]]
    if (obstacleGrid.isEmpty || obstacleGrid(0).isEmpty) return res
    if (obstacleGrid(0)(0) == 1 || obstacleGrid(obstacleGrid.length - 1)(obstacleGrid(0).length - 1) == 1) return res
    val dp = Array.ofDim[Int](obstacleGrid.length + 1, obstacleGrid(0).length + 1)
    dp(0)(0) = 1
    (1 until obstacleGrid.length).foreach(i => {
      if (obstacleGrid(i)(0) == 1) dp(i)(0) = 0 else dp(i)(0) = dp(i - 1)(0)
    })
    (1 until obstacleGrid(0).length).foreach(i => {
      if (obstacleGrid(0)(i) == 1) dp(0)(i) = 0 else dp(0)(i) = dp(0)(i - 1)
    })
    (1 until obstacleGrid.length).foreach(i => (1 until obstacleGrid(0).length).foreach(j => {
      if (obstacleGrid(i)(j) == 1) dp(i)(j) = 0 else dp(i)(j) = dp(i - 1)(j).max(dp(i)(j - 1))
    }))
    if (dp(obstacleGrid.length - 1)(obstacleGrid(0).length - 1) == 0) return res
    var r = obstacleGrid.length - 1
    var c = obstacleGrid(0).length - 1
    while (r != 0 || c != 0) {
      res :+= List(r, c)
      var up = 0
      if (r > 0) up = dp(r - 1)(c)
      var left = 0
      if (c > 0) left = dp(r)(c - 1)
      if (up >= left) r -= 1 else c -= 1
    }
    res :+= List(0, 0)
    res.reverse
  }
}
