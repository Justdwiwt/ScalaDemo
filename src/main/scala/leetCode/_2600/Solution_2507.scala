package leetCode._2600

object Solution_2507 {
  private val primes = (2 to 100000).filter(p => BigInt(p).isProbablePrime(10))

  @scala.annotation.tailrec
  def smallestValue(n: Int): Int = {
    val f = factors(n)
    val sum = f.sum
    if (sum == n) n else smallestValue(sum)
  }

  private def factors(i: Int): List[Int] =
    if (primes.contains(i)) List(i)
    else {
      val p = primes.find(i % _ == 0).get
      p :: factors(i / p)
    }
}
