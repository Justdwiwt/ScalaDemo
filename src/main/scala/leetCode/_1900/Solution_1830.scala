package leetCode._1900

object Solution_1830 {
  private val M: Int = 1000000007

  private def quickmul(x: Int, y: Int): Int = {
    var ret = 1L
    var mul = x.toLong
    var exponent = y
    while (exponent > 0) {
      if ((exponent & 1) == 1) ret = ret * mul % M
      mul = mul * mul % M
      exponent >>= 1
    }
    ret.toInt
  }

  def makeStringSorted(s: String): Int = {
    val n = s.length

    val fac = Array.ofDim[Long](n + 1)
    val facinv = Array.ofDim[Long](n + 1)
    fac(0) = 1L
    facinv(0) = 1L
    (1 to n).foreach(i => {
      fac(i) = fac(i - 1) * i % M
      facinv(i) = quickmul(fac(i).toInt, M - 2)
    })

    val freq = Array.fill(26)(0)
    s.foreach(ch => freq(ch - 'a') += 1)

    var res = 0L
    (0 until n - 1).foreach(i => {
      var rank = 0
      (0 until s(i) - 'a').foreach(j => rank += freq(j))
      var cur = rank * fac(n - i - 1) % M
      (0 until 26).foreach(j => cur = cur * facinv(freq(j)) % M)
      res = (res + cur) % M
      freq(s(i) - 'a') -= 1
    })

    res.toInt
  }
}
