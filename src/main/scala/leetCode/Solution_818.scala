package leetCode

object Solution_818 {
  def racecar(target: Int): Int = {
    val dp = Array.fill(10001)(0)
    if (dp(target) > 0) return dp(target)
    val n = math.floor(log2(target)).toInt + 1
    if (1 << n == target + 1) dp(target) = n
    else {
      dp(target) = racecar((1 << n) - 1 - target) + n + 1
      (0 until n - 1).foreach(m => dp(target) = dp(target).min(racecar(target - (1 << (n - 1)) + (1 << m)) + n + m + 1))
    }
    dp(target)
  }

  def log2(n: Double): Double = math.log(n) / math.log(2)
}
