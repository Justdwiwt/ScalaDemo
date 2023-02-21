package leetCode

object Solution_2572 {
  def squareFreeSubsets(nums: Array[Int]): Int = {
    val primes = Vector(2, 3, 5, 7, 11, 13, 17, 19, 23, 29)
    val M = (1e9 + 7).toLong

    def add(x: Long, y: Long): Long = ((x + y) % M + M) % M

    def primeFactors(x: Int): Option[Int] = primes.indexWhere(x % _ == 0) match {
      case -1 => Some(0)
      case i => primeFactors(x / primes(i)) match {
        case Some(bits) if ((1 << i) & bits) == 0 => Some((1 << i) | bits)
        case _ => None
      }
    }

    nums./:(Vector.fill(1 << primes.size)(1L)) {
      case (dp, n) => primeFactors(n) match {
        case None => dp
        case Some(factors) => Vector.tabulate(dp.size)(bits => {
          if ((factors & bits) != 0) dp(bits)
          else add(dp(bits | factors), dp(bits))
        })
      }
    }(0).toInt - 1
  }
}
