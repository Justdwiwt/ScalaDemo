package leetCode._400

import scala.collection.SortedSet

object Solution_352 {
  class SummaryRanges() {
    private var st = SortedSet.empty[Int]

    def addNum(value: Int): Unit = {
      st += value
    }

    def getIntervals: Array[Array[Int]] = {
      val list = st.toList

      list.tail./:(Array(Array(list.head, list.head)))((acc, x) => {
        if (acc.last(1) + 1 == x) {
          acc.last(1) = x
          acc
        }
        else acc :+ Array(x, x)
      })
    }
  }
}
