package leetCode

object Solution_1043 {
  def maxSumAfterPartitioning(A: Array[Int], K: Int): Int = {
    val dp = Array.fill(A.length + 1)(0)
    (1 to A.length).foreach(i => (1 to K).withFilter(j => i - j >= 0).foreach(j => dp(i) = dp(i).max(dp(i - j) + A.slice(i - j, i).max * j)))
    dp(A.length)
  }
}
