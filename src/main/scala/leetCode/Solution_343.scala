package leetCode

object Solution_343 {
  def integerBreak(n: Int): Int = {
    val dp = Array.fill(n + 1)(0)
    dp(1) = 1
    (2 until n + 1).foreach(i => (1 until i).reverse.foreach(j => {
      dp(i) = dp(i).max(dp(j) * (i - j))
      dp(i) = dp(i).max(j * (i - j))
    }))
    dp(n)
  }
}
