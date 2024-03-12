package leetCode._500

import scala.collection.immutable

object Solution_497 {
  //  class Solution(_rects: Array[Array[Int]]) {
  //    val random = scala.util.Random
  //
  //    def getRnd(mx: Int): Int = random.nextInt.abs % mx
  //
  //    val prefixSums = immutable.SortedMap.from(_rects.map(r => (r(2) - r(0) + 1) * (r(3) - r(1) + 1))
  //      ./:(List(0)) { case (list, area) => (list.head + area) +: list }
  //      .reverse
  //      .tail
  //      .zipWithIndex
  //    )
  //    val sum = prefixSums.keys.last
  //
  //    def pick(): Array[Int] = {
  //      val r = _rects(prefixSums.iteratorFrom(getRnd(sum + 1)).next._2)
  //      Array(r(0) + getRnd(r(2) - r(0) + 1), r(1) + getRnd(r(3) - r(1) + 1))
  //    }
  //  }
}
