package leetCode._2600

object Solution_2523 {
  private def isPrime(n: Int): Boolean =
    if (n <= 1) false
    else !(2 to Math.sqrt(n).toInt).exists(n % _ == 0)

  private def primesInRange(right: Int): List[Int] =
    (2 to right).filter(isPrime).toList

  def closestPrimes(left: Int, right: Int): Array[Int] = {
    val primes = primesInRange(right)
    val closest = primes
      .sliding(2)
      .collect { case List(a, b) if a >= left => (a, b) }
      .reduceLeftOption((p1, p2) =>
        if ((p1._2 - p1._1) < (p2._2 - p2._1) ||
          ((p1._2 - p1._1) == (p2._2 - p2._1) && p1._1 < p2._1)) p1 else p2
      )
      .getOrElse((-1, -1))
    Array(closest._1, closest._2)
  }
}
