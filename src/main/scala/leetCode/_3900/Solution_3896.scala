package leetCode._3900

import scala.collection.immutable.TreeSet

object Solution_3896 {
  private val primes = TreeSet((2 until 100005).filter(BigInt(_).isProbablePrime(20)): _*)

  def minOperations(nums: Array[Int]): Int =
    nums.zipWithIndex.map {
      case (x, i) if i % 2 == 0 =>
        if (primes(x)) 0
        else primes.from(x).head - x

      case (2, _) => 2
      case (x, _) => if (primes(x)) 1 else 0
    }.sum
}
