package leetCode

object Solution_1269 {
  def numWays(steps: Int, arrLen: Int): Int = {
    val M = 1000000007
    var dp = Array.fill(502)(0)
    dp(0) = 1
    var tmp = 0
    dp :+= 1
    (1 to steps).foreach(s => (0 until arrLen.min(s + 1).min(steps - s + 1)).foreach(i => {
      tmp = 0
      val t = dp(i)
      dp(i) = tmp
      tmp = t
      dp(i) = (tmp + dp(i) + dp(i + 1)) % M
    }))
    dp(0)
  }
}
