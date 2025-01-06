package leetCode._3500

object Solution_3405 {
  val M: BigInt = BigInt(1000000007)

  private def modInverse(a: BigInt, mod: BigInt): BigInt =
    a.modPow(mod - 2, mod)

  private def comb(n: Int, k: Int): BigInt =
    if (k > n) BigInt(0)
    else {
      var num = BigInt(1)
      var denom = BigInt(1)
      (0 until k).foreach(i => {
        num = num * (n - i) % M
        denom = denom * (i + 1) % M
      })
      num * modInverse(denom, M) % M
    }

  private def pow(base: Int, exp: Int, mod: BigInt): BigInt = {
    var res = BigInt(1)
    var b = BigInt(base)
    var e = exp
    while (e > 0) {
      if (e % 2 == 1) res *= b % mod
      b = b * b % mod
      e /= 2
    }
    res
  }

  def countGoodArrays(n: Int, m: Int, k: Int): Int =
    (comb(n - 1, k) * BigInt(m) % M * pow(m - 1, n - k - 1, M) % M).toInt
}
