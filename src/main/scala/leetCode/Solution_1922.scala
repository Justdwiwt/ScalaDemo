package leetCode

import scala.math.BigInt

object Solution_1922 {
  def countGoodNumbers(n: Long): Int = {
    val M = 1e9.toInt + 7
    val c = n / 2
    val even = BigInt(5).modPow(BigInt(c + n % 2), BigInt(M))
    val odd = BigInt(4).modPow(BigInt(c), BigInt(M))
    (even * odd % M).toInt
  }
}
