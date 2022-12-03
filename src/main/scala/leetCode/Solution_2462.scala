package leetCode

import scala.collection.immutable.TreeSet

object Solution_2462 {
  def totalCost(costs: Array[Int], k: Int, candidates: Int): Long = {
    val indexed = costs.zipWithIndex

    def f(cnt: Int, left: TreeSet[(Int, Int)], right: TreeSet[(Int, Int)], l: Int, r: Int): Long =
      if (cnt == k) 0L
      else {
        val (newLeft, newL) = Iterator
          .iterate((left, l)) { case (left, l) => (left + indexed(l), l + 1) }
          .dropWhile { case (left, l) => left.size < candidates && l <= r }
          .next()
        val (newRight, newR) = Iterator
          .iterate((right, r)) { case (right, r) => (right + indexed(r), r - 1) }
          .dropWhile { case (right, r) => right.size < candidates && r >= newL }
          .next()

        val bestLeft = newLeft.headOption.map { case (cost, _) => cost }.getOrElse(Int.MaxValue)
        val bestRight = newRight.headOption.map { case (cost, _) => cost }.getOrElse(Int.MaxValue)

        if (bestLeft <= bestRight) bestLeft + f(cnt + 1, newLeft.tail, newRight, newL, newR)
        else bestRight + f(cnt + 1, newLeft, newRight.tail, newL, newR)
      }

    f(cnt = 0, left = TreeSet.empty, right = TreeSet.empty, l = 0, r = costs.indices.last)
  }
}
