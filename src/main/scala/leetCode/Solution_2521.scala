package leetCode

import scala.collection.mutable

object Solution_2521 {
  private val primes = mutable.Map.empty[Int, mutable.Set[Int]]
  primes(2) = mutable.Set(2)
  primes(3) = mutable.Set(3)
  (4 to 1000).foreach(i => primes(i) = getAllPrimes(i))

  private def getAllPrimes(number: Int): mutable.Set[Int] = {
    val primes = mutable.Set.empty[Int]
    var current = number
    (2 to (number / 2) + 1).foreach(i => while (current % i == 0) {
      primes += i
      current = current / i
    })
    if (primes.isEmpty) primes += number
    primes
  }

  def distinctPrimeFactors(nums: Array[Int]): Int = {
    val unqiuePrimes = mutable.Set.empty[Int]
    nums.foreach(num => unqiuePrimes ++= primes(num))
    unqiuePrimes.size
  }
}
