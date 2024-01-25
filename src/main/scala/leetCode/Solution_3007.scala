package leetCode

object Solution_3007 {
  def findMaximumNumber(k: Long, x: Int): Long = {
    var left = 0L
    var right = (k + 1) << x
    while (left + 1 < right) {
      val mid = (left + right) >>> 1
      if (cntOne(mid, x) <= k) left = mid
      else right = mid
    }
    left
  }

  private def cntOne(num: Long, x: Int): Long = {
    var res = 0L
    var i = x - 1
    var n = num >> i
    while (n > 0) {
      res += (n / 2) << i
      if (n % 2 > 0) {
        val mask = (1L << i) - 1
        res += (num & mask) + 1
      }
      n >>= x
      i += x
    }
    res
  }
}
