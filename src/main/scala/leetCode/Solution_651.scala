package leetCode

object Solution_651 {
  def maxA(N: Int): Int = {
    val dp = Array.fill(N + 1)(0)
    dp.indices.drop(1).foreach(i => {
      dp(i) = dp(i - 1) + 1
      (2 until i - 1).foreach(j => dp(i) = dp(i).max(dp(j - 1) * (i - j)))
    })
    dp(N)
  }
}
