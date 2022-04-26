package leetCode

object Solution_1802 {
  def maxValue(n: Int, index: Int, maxSum: Int): Int = {
    var res = 1
    var l = index
    var r = index
    var sum = n
    while (sum <= maxSum) {
      sum += r - l + 1
      res += 1
      l = if (l == 0) 0 else l - 1
      r = if (r == n - 1) n - 1 else r + 1
      if (l == 0 && r == n - 1 && n < maxSum - sum) {
        return res + (maxSum - sum) / n
      }
    }
    res - 1
  }
}
