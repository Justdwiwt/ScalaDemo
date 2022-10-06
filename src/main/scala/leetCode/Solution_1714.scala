package leetCode

object Solution_1714 {
  def solve(nums: Array[Int], queries: Array[Array[Int]]): Array[Int] = {
    val M = (1e9 + 7).toInt
    val n = nums.length
    val m = queries.length
    val dp = Array.fill(n, 110)(0L)
    (n - 1 to 0 by (-1)).foreach(i => {
      dp(i)(0) = nums(i) % M
      (1 to 100).foreach(j => {
        dp(i)(j) = nums(i)
        if (i + j < n) dp(i)(j) += dp(i + j)(j)
        dp(i)(j) %= M
      })
    })
    val res = Array.fill(m)(0)
    queries.indices.foreach(i => {
      val x = queries(i).head
      val y = queries(i)(1)
      if (y <= 100) res(i) = dp(x)(y).toInt
      else {
        var now = nums(x)
        (x + y until n by y).foreach(j => now = (now + nums(j)) % M)
        res(i) = now
      }
    })
    res
  }
}
