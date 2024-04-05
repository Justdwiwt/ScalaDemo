package leetCode._500

import scala.collection.immutable
import scala.collection.immutable.SortedMap
import scala.util.Random

object Solution_497 {
  class Solution(_rects: Array[Array[Int]]) {
    val random: Random.type = scala.util.Random

    private def getRnd(mx: Int): Int =
      random.nextInt.abs % mx

    val prefixSums: SortedMap[Int, Int] = immutable.SortedMap(_rects
      .map(r => (r(2) - r(0) + 1) * (r(3) - r(1) + 1))
      .foldLeft(List(0)) { case (list, area) => (list.head + area) +: list }
      .reverse
      .tail
      .zipWithIndex: _*
    )

    val sum: Int = prefixSums.keys.last

    def pick(): Array[Int] = {
      val r = _rects(prefixSums.iteratorFrom(getRnd(sum + 1)).next._2)
      Array(r.head + getRnd(r(2) - r.head + 1), r(1) + getRnd(r(3) - r(1) + 1))
    }
  }
}
