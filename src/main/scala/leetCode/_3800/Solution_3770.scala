package leetCode._3800

object Solution_3770 {
  def largestPrime(n: Int): Int = {
    if (n < 2) return 0
    val isPrime = Array.fill(n + 1)(true)
    isPrime(0) = false
    isPrime(1) = false
    (2 to math.sqrt(n).toInt).foreach(i => if (isPrime(i)) (i * i to n by i).foreach(isPrime(_) = false))
    val primes = (2 to n).filter(isPrime).map(_.toLong)
    primes
      .scanLeft(0L)(_ + _)
      .filter(s => s <= n && isPrime(s.toInt))
      .lastOption
      .getOrElse(0L)
      .toInt
  }
}
