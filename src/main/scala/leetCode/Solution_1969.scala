package leetCode

object Solution_1969 {
  val M = 1000000007

  def minNonZeroProduct(p: Int): Int = {
    if (p == 1) return 1
    if (p == 2) return 6
    val mx = (1L << p) - 1
    val t = mx / 2
    var res = f((mx - 1) % M, t) % M
    res = (res * (mx % M)) % M
    res.toInt
  }

  def f(_a: Long, _b: Long): Long = {
    var res = 1L
    var a = _b
    var b = _a
    while (a > 0) {
      if ((a & 1) == 1) res = res * b % M
      b = b * b % M
      a >>= 1
    }
    res % M
  }
}
