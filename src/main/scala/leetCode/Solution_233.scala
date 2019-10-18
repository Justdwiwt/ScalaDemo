package leetCode

object Solution_233 {
  def countDigitOne(n: Int): Int = {
    var res: Long = 0
    var i: Long = 1
    while (i <= n) {
      val k: Long = i * 10
      res += (n / k) * i + min(max(n % k - i + 1, 0), i)
      i *= 10
    }
    res.toInt
  }

  def min(a: Long, b: Long): Long = {
    if (b < a) b
    else a
  }

  def max(a: Long, b: Long): Long = {
    if (b < a) a
    else b
  }
}
