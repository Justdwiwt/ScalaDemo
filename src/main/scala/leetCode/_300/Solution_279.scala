package leetCode._300

object Solution_279 {
  def numSquares(n: Int): Int = {
    val dp = Array.fill(n + 1)(Int.MaxValue)
    dp(0) = 0
    (1 to n).foreach(i => (1 to math.sqrt(i).toInt).foreach(j => dp(i) = dp(i).min(dp(i - j * j) + 1)))
    dp(n)
  }
}
