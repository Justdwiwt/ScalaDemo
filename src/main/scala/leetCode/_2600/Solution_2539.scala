package leetCode._2600

object Solution_2539 {
  private val MX = 10005
  private val M = 1000000007
  private val fact = Array.fill(MX)(0L)
  private val infact = Array.fill(MX)(0L)

  fact(0) = 1
  infact(0) = 1

  (1 until MX).foreach(i => {
    fact(i) = (fact(i - 1) * i) % M
    infact(i) = (infact(i - 1) * BigInt(i).modPow(M - 2, M).toLong) % M
  })

  def countGoodSubsequences(s: String): Int = {
    def myComb(a: Int, b: Int): Long = {
      fact(a) * infact(b) % M * infact(a - b) % M
    }

    var freq = 1
    var res = 0L
    var log = s.groupBy(identity).mapValues(_.length)

    while (log.nonEmpty) {
      var cur = 1L
      log.toList.foreach { case (k, v) =>
        cur = (cur * (myComb(v, freq) + 1)) % M
        if (v == freq) log -= k
      }
      res = (res + cur - 1) % M
      freq += 1
    }
    res.toInt
  }
}
