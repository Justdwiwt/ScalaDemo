package leetCode

import java.math.BigInteger

object Solution_1621 {
  def numberOfSets(n: Int, k: Int): Int = {
    val M = (1e9 + 7).toInt
    var res = BigInteger.valueOf(1)
    (1 until k * 2 + 1).foreach(i => {
      res = res.multiply(BigInteger.valueOf(n + k - i))
      res = res.divide(BigInteger.valueOf(i))
    })
    res = res.mod(BigInteger.valueOf(M))
    res.intValue()
  }
}
