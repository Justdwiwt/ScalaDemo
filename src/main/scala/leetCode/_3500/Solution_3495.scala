package leetCode._3500

import scala.math.BigInt.int2bigInt

object Solution_3495 {
  def minOperations(queries: Array[Array[Int]]): Long = {
    def f(n: Int): BigInt =
      if (n == 0) BigInt(0)
      else {
        val m = n.bitLength
        val k = (m - 1) / 2 * 2
        val res = (BigInt(1) << k) * k / 2 - (BigInt(1) << k) / 3
        res + ((m + 1) / 2) * (BigInt(n) + 1 - (BigInt(1) << k))
      }

    queries.map { case Array(l, r) => (f(r) - f(l - 1) + 1) / 2 }.sum.toLong
  }
}
