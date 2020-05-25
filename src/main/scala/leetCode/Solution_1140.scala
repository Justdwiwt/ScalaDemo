package leetCode

object Solution_1140 {
  def stoneGameII(piles: Array[Int]): Int = {
    val dp = Array.ofDim[Int](101, 101)
    val arr = Array.fill(piles.length + 1)(0)
    (1 to piles.length).foreach(i => arr(i) = arr(i - 1) + piles(i - 1))
    (0 to piles.length).foreach(i => dp(piles.length)(i) = 0)
    (piles.length - 1 to 0 by (-1)).foreach(i => {
      val t = piles.length - i
      (piles.length - 1 until 0 by (-1)).foreach(j => {
        if (j >= t) dp(i)(j) = arr(piles.length) - arr(i)
        else (1 to j).foreach(k => dp(i)(j) = dp(i)(j).max(arr(piles.length) - arr(i) - dp(i + k)((piles.length - 1).min((2 * k).max(j)))))
      })
    })
    dp(0)(1).max(dp(0)(2))
  }
}
