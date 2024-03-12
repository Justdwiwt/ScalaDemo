package leetCode._1200

object Solution_1175 {
  val M: Int = math.pow(10, 9).toInt + 7

  lazy val primes: Stream[Int] =
    2 #:: Stream.from(3).filter(x => !primes.takeWhile(_ <= math.sqrt(x)).exists(x % _ == 0))

  lazy val factorials: Stream[BigInt] =
    1 #:: factorials.zip(Stream.from(1)).map(x => x._1 * x._2)

  def numPrimeArrangements(n: Int): Int = {
    val cnt = primes.takeWhile(_ <= n).size
    ((factorials(n - cnt) * factorials(cnt)) % M).toInt
  }
}
