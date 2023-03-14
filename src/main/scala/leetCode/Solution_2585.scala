package leetCode

object Solution_2585 {
  def waysToReachTarget(target: Int, types: Array[Array[Int]]): Int = {
    val M = (1e9 + 7).toInt
    val dp = Array.fill(types.length + 1, target + 1)(0)
    dp(0)(0) = 1
    (1 to types.length).foreach(i => {
      val t = types(i - 1)(1)
      (0 to target).foreach(j => {
        var k = 0
        while (k <= types(i - 1).head && j - t * k >= 0) {
          dp(i)(j) += dp(i - 1)(j - k * t)
          dp(i)(j) = dp(i)(j) % M
          k += 1
        }
      })
    })
    dp(types.length)(target)
  }
}
