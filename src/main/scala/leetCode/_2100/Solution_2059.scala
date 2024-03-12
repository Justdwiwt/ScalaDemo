package leetCode._2100

import scala.collection.immutable.BitSet

object Solution_2059 {
  private val Range = 0 to 1000

  def minimumOperations(nums: Array[Int], start: Int, goal: Int): Int = {
    @scala.annotation.tailrec
    def f(xs: Set[Int], visited: Set[Int], numOperations: Int): Int =
      if (xs.isEmpty) -1
      else xs
        .iterator
        .flatMap(x => nums
          .iterator
          .flatMap(num => Iterator(x + num, x - num, x ^ num).filter(!xs.contains(_)).filter(!visited.contains(_))))
        .partition(Range.contains) match {
        case (inRange, _) if Range.contains(goal) =>
          val newXs = inRange.toSet
          if (newXs.contains(goal)) numOperations + 1 else f(newXs, visited | xs, numOperations + 1)
        case (_, notInRange) if notInRange.contains(goal) => numOperations + 1
        case (inRange, _) => f(inRange.toSet, visited | xs, numOperations + 1)
      }

    if (start == goal) 0 else f(BitSet(start).filter(Range.contains), BitSet.empty, 0)
  }
}
