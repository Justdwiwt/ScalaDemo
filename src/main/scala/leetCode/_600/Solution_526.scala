package leetCode._600

import scala.collection.immutable.BitSet

object Solution_526 {
  def countArrangement(n: Int): Int = {
    def f(set: Set[Int], i: Int): Int =
      if (i > n) 1
      else set
        .iterator
        .collect { case j if i % j == 0 || j % i == 0 => f(set - j, i + 1) }
        .sum

    f(BitSet(1 to n: _*), 1)
  }
}
