package leetCode

object Solution_813 {
  def largestSumOfAverages(A: Array[Int], K: Int): Double = {
    val dp = Array.ofDim[Double](A.length + 1, K + 1)
    val sum = Array.fill(A.length + 1)(0.0)
    (1 to A.length).foreach(i => {
      sum(i) = sum(i - 1) + A(i - 1)
      dp(i)(1) = sum(i) / i
    })
    (1 to A.length).foreach(i => (2 to K).foreach(k => (0 until i).foreach(j => {
      dp(i)(k) = dp(i)(k).max(dp(j)(k - 1) + (sum(i) - sum(j)) / (i - j))
    })))
    dp(A.length)(K)
  }
}
