package leetCode._1100

object Solution_1067 {
  def digitsCount(d: Int, low: Int, high: Int): Int = {
    (count(d, high) - count(d, low - 1)).toInt
  }

  private def count(d: Int, n: Int): Long = {
    var res = 0L
    var i = 1L
    while (i <= n) {
      val dvid: Long = i * 10
      val high: Long = n / dvid
      val cur: Long = (n / i) % 10
      val low: Long = n % i
      if (cur > d) res += (high + 1) * i
      else if (cur < d) res += high * i
      else res += high * i + low + 1
      if (d == 0) res -= i
      i *= 10
    }
    res
  }
}
