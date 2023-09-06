package leetCode

object Solution_2842 {
  private val M = (1e9 + 7).toInt

  def countKSubsequencesWithMaxBeauty(s: String, k: Int): Int = {
    val chars = Array.fill(26)(0)
    val dp = Array.fill(27, k + 1)(-1L)
    s.toCharArray.foreach(c => chars(c - 'a') += 1)
    val distinct = chars.count(_ > 0)
    if (distinct < k) return 0
    val sorted = chars.sorted
    var taken = 0
    var res = 1
    (26 - k to 25).reverse.foreach(i => {
      if (sorted(i) != sorted(26 - k)) {
        res = ((1L * res % M * sorted(i) % M) % M).toInt
        taken += 1
      }
    })
    (0 until 26).foreach(i => if (sorted(i) != sorted(26 - k)) sorted(i) = 0)
    (1L * res % M * f(sorted, 0, k - taken, dp) % M % M).toInt
  }

  private def f(chars: Array[Int], i: Int, left: Int, dp: Array[Array[Long]]): Long = {
    if (left < 0) return 0L
    if (i == 26) {
      dp(i)(left) = if (left == 0) 1L else 0L
      return dp(i)(left)
    }
    if (dp(i)(left) != -1) return dp(i)(left)
    dp(i)(left) = (1L * (f(chars, i + 1, left - 1, dp) % M * chars(i)) % M + f(chars, i + 1, left, dp) % M) % M
    dp(i)(left)
  }
}
