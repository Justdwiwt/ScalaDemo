package leetCode._1900

object Solution_1808 {
  def maxNiceDivisors(primeFactors: Int): Int = {
    val M = 1000000007
    val maxVal = 0.max((primeFactors - 2) / 3)
    ((primeFactors - 3 * maxVal) * BigInt(3).modPow(maxVal, M)).mod(M).toInt
  }
}
