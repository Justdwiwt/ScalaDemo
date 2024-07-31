package leetCode._3300

import scala.collection.mutable

object Solution_3233 {
  val st: mutable.SortedSet[Int] = mutable.SortedSet(2 to 32000: _*)
  private val primeNumbersUpTo32k = {
    def nextPrime(s: mutable.SortedSet[Int]): Stream[Int] =
      if (s.isEmpty) Stream.empty
      else {
        val head = s.head
        head #:: nextPrime(s.filter(_ % head != 0))
      }

    nextPrime(st).toList
  }

  def nonSpecialCount(l: Int, r: Int): Int =
    r - l + 1 - primeNumbersUpTo32k.count(p => l <= p * p && p * p <= r)
}
