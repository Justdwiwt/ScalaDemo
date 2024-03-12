package leetCode._2600

object Solution_2521 {
  def distinctPrimeFactors(nums: Array[Int]): Int = {
    lazy val primes: Stream[Int] = 2 #:: Stream.iterate[Int](3)(x => Stream
      .iterate(x + 2)(_ + 2)
      .find(i => primes.takeWhile(p => p * p <= i).forall(i % _ > 0))
      .get)
    nums.flatMap(x => primes.takeWhile(_ <= x).filter(x % _ == 0).toSet).toSet.size
  }
}
