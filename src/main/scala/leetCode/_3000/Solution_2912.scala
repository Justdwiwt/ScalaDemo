package leetCode._3000

object Solution_2912 {
  def numberOfWays(n: Int, m: Int, k: Int, source: Array[Int], dest: Array[Int]): Int = {
    val M = BigInt(1000000007)
    var dp = Array(BigInt(0), BigInt(0), BigInt(0), BigInt(0))
    dp((if (source(1) == dest(1)) 2 else 0) + (if (source(0) == dest(0)) 1 else 0)) = 1

    (1 to k).foreach(_ => {
      val dp1 = Array(BigInt(0), BigInt(0), BigInt(0), BigInt(0))
      dp1(0) = ((dp(0) * (n + m - 4) + dp(1) * (n - 1) + dp(2) * (m - 1)) % M).toInt
      dp1(1) = (dp(0) + dp(1) * (m - 2) + dp(3) * (m - 1)) % M
      dp1(2) = (dp(0) + dp(2) * (n - 2) + dp(3) * (n - 1)) % M
      dp1(3) = (dp(1) + dp(2)) % M
      dp = dp1
    })

    dp(3).toInt
  }
}
